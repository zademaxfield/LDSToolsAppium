package LDSToolsAppium;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Instant;

import com.google.gson.Gson;
import okhttp3.CacheControl;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;

class TestAuthenticationManager {
    private static final Object LOCK = new Object();

    private TestWam2CredentialsManager credentialsManager;
    private TestWam2Session session;

    final private TestWamConfig config = new TestWamConfig();
    final private String charset = StandardCharsets.UTF_8.name();
    final private MediaType applicationJson = MediaType.get("application/json;charset=" + charset);
    final private Gson gson = new Gson();
    final private HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

    public TestAuthenticationManager(TestWam2CredentialsManager credentialsManager) {
        this.credentialsManager = credentialsManager;
    }

    public String getCookie() {
        synchronized (LOCK) {
            if (checkAuthenticatedConnection()) {
                if (session != null) {
                    return session.cookie;
                }
            }
            return "";
        }
    }

    private boolean checkAuthenticatedConnection() {
        try {
            if (session != null && !session.isExpired()) {
                return true;
            }
            return authenticate(credentialsManager.username, credentialsManager.password);
        } catch (Exception e) {
            System.err.println("Failed to sign in.");
            e.printStackTrace(System.err);
        }
        return false;
    }

    private boolean authenticate(String username, String password) throws IOException {
        final String idToken = getIdToken();
        if (idToken == null) {
            return false;
        }

        final String json = "{\"username\": \"" + username + "\",\"password\":\"" + password + "\"}";

        final Request request = new Request.Builder()
                .cacheControl(CacheControl.FORCE_NETWORK)
                .addHeader("User-Agent", "Member Tools Testing")
                .addHeader("Authorization", "Bearer " + idToken)
                .addHeader("Accept-Charset", charset)
                .post(RequestBody.create(applicationJson, json))
                .url(config.wamEndpoint)
                .build();

        final Response response = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()
                .newCall(request).execute();
        final ResponseBody body = response.body();
        if (!response.isSuccessful() && body == null) {
            return false;
        }
        if (body == null) {
            return false;
        }

        TestDtoWam2Response dto = gson.fromJson(body.string(), TestDtoWam2Response.class);
        if (dto.getName().isEmpty() || dto.getValue().isEmpty()) {
            return false;
        }

        Instant expiration = Instant.ofEpochMilli(response.sentRequestAtMillis()).plusSeconds(config.maxAge);
        session = new TestWam2Session(dto.getCookie(), expiration);

        return true;
    }

    private String getIdToken() throws IOException {
        final FormBody formBody = new FormBody.Builder()
                .add("client_id", config.clientId)
                .add("client_secret", config.clientSecret)
                .add("grant_type", "client_credentials")
                .add("scope", "openid")
                .build();

        final Request request = new Request.Builder()
                .url(config.tokenEndpoint)
                .addHeader("User-Agent", "Member Tools Testing")
                .addHeader("Accept-Charset", charset)
                .addHeader("Content-Type", "application/x-www-form-urlencoded;charset=" + charset)
                .post(formBody)
                .build();

        Response response = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()
                .newCall(request).execute();
        ResponseBody body = response.body();
        if (response.isSuccessful() && body != null) {
            TestDtoTokenResponse dto = gson.fromJson(body.string(), TestDtoTokenResponse.class);
            return validateClientTokenResponse(dto);
        }

        return null;
    }

    private String validateClientTokenResponse(TestDtoTokenResponse dto) {
        if (dto == null) {
            return null;
        }
        if (!dto.getError().isEmpty()) {
            return null;
        }
        if (dto.getIdToken().isEmpty()) {
            return null;
        }
        return dto.getIdToken();
    }
}