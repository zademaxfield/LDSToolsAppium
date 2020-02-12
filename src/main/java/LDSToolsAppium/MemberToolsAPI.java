package LDSToolsAppium;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.*;
import okhttp3.logging.HttpLoggingInterceptor;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.annotation.Nullable;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class MemberToolsAPI {


    public void toolsService() throws Exception {
        LDSWeb myWeb = new LDSWeb();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient httpClient = new OkHttpClient.Builder()
                .authenticator(new Authenticator() {
                    @Nullable
                    @Override
                    public Request authenticate(@Nullable Route route, Response response) throws IOException {
                        if (response.request().header("Authorization") != null) {
                            System.out.println("Authorization Not Found!");
                            return null;
                        }

                        System.out.println("Authenticating for response: " + response);
                        System.out.println("Challenges: " + response.challenges());
                        String credential = Credentials.basic("LDSTools2", "toolstester");
                        return response.request().newBuilder()
                                .header("Authorization", credential)
                                .build();
                    }
                })
                .connectTimeout(Duration.ofSeconds(360))
                .writeTimeout(Duration.ofSeconds(360))
                .readTimeout(Duration.ofSeconds(360))
                .build();


        Request request = new Request.Builder()
//                .url("https://wam-membertools-api-stage.churchofjesuschrist.org/api/")
                .url("https://wam-membertools-api-stage.churchofjesuschrist.org/api/v4/user")
                .build();

        try (Response response = httpClient.newCall(request).execute()) {
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }

//        myWeb.loginSwagger();


    }
}
