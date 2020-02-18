package LDSToolsAppium;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;

public class TestAuthenticationInterceptor implements Interceptor {

    private TestAuthenticationManager authenticationManager;

    public TestAuthenticationInterceptor(TestAuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        String cookie = authenticationManager.getCookie();
        if (cookie.isEmpty()) {
            return errorResponse(request);
        }
        Request.Builder builder = request.newBuilder()
                .addHeader("Cookie", cookie);

        return chain.proceed(builder.build());
    }

    private Response errorResponse(Request request) {
        return new Response.Builder()
                .request(request)
                .protocol(Protocol.HTTP_1_1)
                .code(480)
                .message("Failed to authenticate")
                .build();
    }


}
