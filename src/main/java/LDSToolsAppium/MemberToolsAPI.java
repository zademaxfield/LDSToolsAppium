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
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        TestWam2CredentialsManager credentialsManager = new TestWam2CredentialsManager("androidtest2", "androidtest123");

        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(new TestAuthenticationInterceptor(new TestAuthenticationManager(credentialsManager)))
                .addInterceptor(loggingInterceptor)
                .connectTimeout(Duration.ofSeconds(360))
                .writeTimeout(Duration.ofSeconds(360))
                .readTimeout(Duration.ofSeconds(360))
                .build();


        Request request = new Request.Builder()
//                .url("https://wam-membertools-api-stage.churchofjesuschrist.org/api/")
                .url("https://identity-util-service-int.churchofjesuschrist.org/api/checkSession")
                .build();

        try (Response response = httpClient.newCall(request).execute()) {
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }

//        myWeb.loginSwagger();


    }
}
