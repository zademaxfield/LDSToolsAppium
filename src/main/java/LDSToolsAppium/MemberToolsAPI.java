package LDSToolsAppium;

import com.google.gson.*;

import com.google.gson.reflect.TypeToken;
import okhttp3.*;
import okhttp3.logging.HttpLoggingInterceptor;


import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.json.Json;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.annotation.Nullable;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MemberToolsAPI {

    Response householdAPI = null;


    //Login credentials for the API
    public OkHttpClient loginCred() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        byte[] decodeBytes = Base64.decodeBase64("UDFrQFNwMTc=");

        TestWam2CredentialsManager credentialsManager = new TestWam2CredentialsManager("zmaxfield", new String(decodeBytes));

        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(new TestAuthenticationInterceptor(new TestAuthenticationManager(credentialsManager)))
                .addInterceptor(loggingInterceptor)
                .connectTimeout(Duration.ofSeconds(360))
                .writeTimeout(Duration.ofSeconds(360))
                .readTimeout(Duration.ofSeconds(360))
                .build();

        return httpClient;
    }


    //TODO: Need to set the url to be passed in.
    public Request requestURL() {
        Request request = new Request.Builder()
                .url("https://wam-membertools-api-stage.churchofjesuschrist.org/api/v4/organizations?units=21628")
//                .url("https://identity-util-service-int.churchofjesuschrist.org/api/checkSession")
//                .url("https://wam-membertools-api-stage.churchofjesuschrist.org/api/v4/user")
                .addHeader("X-Proxy-User" , "kroqbandit")
                .build();
        return request;
    }

    public Request requestProxyURL(String apiUrl, String proxyUser ) {
        Request request = new Request.Builder()
                .url(apiUrl)
                .addHeader("X-Proxy-User" , proxyUser)
                .build();
        return request;
    }


    //Test Request
    public void apiRequest() {
        OkHttpClient httpClient = loginCred();
        Request request = requestURL();
        JsonParser parser = new JsonParser();
        String responseData;
//        String myPositions = "";
        ArrayList<String> myPositions = new ArrayList<String>();


        try (Response response = httpClient.newCall(request).execute()) {
            assert response.body() != null;
            responseData = response.body().string();
            System.out.println("Response String: " + responseData);
            JsonElement jsonElement = parser.parse(responseData);
            System.out.println("Json element to String: " + jsonElement.toString());
            if (jsonElement instanceof JsonObject) {
                System.out.println("JSON Object!");
                System.out.println("Name: " + ((JsonObject) jsonElement).get("name").getAsString());
            } else if (jsonElement instanceof JsonArray) {
                System.out.println("JSON Array!");
//                JsonArray jsonData = new JsonArray(((JsonArray) jsonElement).size());
                JsonArray jsonData = jsonElement.getAsJsonArray();

                for (JsonElement orgName : jsonData) {
                    JsonObject orgObject = orgName.getAsJsonObject();
                    String myUuid = orgObject.get("uuid").getAsString();
                    String myOrgName = orgObject.get("name").getAsString();
                    String myUnitNumber = orgObject.get("unitNumber").getAsString();
                    String myOrgTypes = orgObject.get("orgTypes").getAsString();
//                    String myPositions = orgObject.get("positions").getAsString();
//                    String myPositions = orgObject.getAsJsonArray("positions").getAsString();
                    if (orgObject.has("positions")) {
                        JsonArray positionsArray = orgObject.getAsJsonArray("positions");
                        for (JsonElement posElement : positionsArray ) {
//                        JsonObject orgPos = posElement.getAsJsonObject();
                            myPositions.add(posElement.getAsString());
                        }
                    }



                    System.out.println("****************************");
                    System.out.println("uuid: " + myUuid);
                    System.out.println("Org Name: " + myOrgName);
                    System.out.println("Unit Number: " + myUnitNumber);
                    System.out.println("Org Type: " + myOrgTypes);
                    System.out.println("Positions: " + myPositions);
                    System.out.println("****************************");
                }
            }

//            System.out.println(jsonData);
//            JsonObject rootObj = parser.parse(jsonData).getAsJsonObject();




//            JsonObject jsonObject = (new JsonParser()).parse(jsonData).getAsJsonObject();
//            System.out.println("Name: " + jsonObject.get("name").getAsString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void getOrganizationMembers(String organizationName, String proxyLogin, String unitNumber) {
        OkHttpClient httpClient = loginCred();
        Request request = requestProxyURL("https://wam-membertools-api-stage.churchofjesuschrist.org/api/v4/organizations?units=" + unitNumber, proxyLogin );
        JsonParser parser = new JsonParser();
        String responseData;
//        String myPositions = "";
        ArrayList<String> myPositions = new ArrayList<String>();
        ArrayList<String> memberNames = new ArrayList<String>();


        try (Response response = httpClient.newCall(request).execute()) {
            assert response.body() != null;
            responseData = response.body().string();
            System.out.println("Response String: " + responseData);
            JsonElement jsonElement = parser.parse(responseData);
            System.out.println("Json element to String: " + jsonElement.toString());
            if (jsonElement instanceof JsonObject) {
                System.out.println("JSON Object!");
                System.out.println("Name: " + ((JsonObject) jsonElement).get("name").getAsString());
            } else if (jsonElement instanceof JsonArray) {
                System.out.println("JSON Array!");
//                JsonArray jsonData = new JsonArray(((JsonArray) jsonElement).size());
//                JsonArray jsonData = jsonElement.getAsJsonArray();
                JsonArray jsonData = jsonElement.getAsJsonArray();

                for (JsonElement orgName : jsonData) {
                    JsonObject orgObject = orgName.getAsJsonObject();
//                    String myUuid = orgObject.get("uuid").getAsString();
//                    String myOrgName = orgObject.get("name").getAsString();
//                    String myUnitNumber = orgObject.get("unitNumber").getAsString();
//                    String myOrgTypes = orgObject.get("orgTypes").getAsString();
//                    String myChildOrg = orgObject.get("childOrgs").getAsString();

                    String myUuid = orgObject.get("uuid").getAsString();
                    String myOrgName = orgObject.get("name").getAsString();
                    String myOrgTypes = orgObject.get("orgTypes").getAsString();
                    if (organizationName.equalsIgnoreCase(myOrgName)) {
                        if (orgObject.has("positions")) {
                            JsonArray positionsArray = orgObject.getAsJsonArray("positions");
                            for (JsonElement posElement : positionsArray ) {
                                myPositions.add(posElement.getAsString());
                                if (myOrgName.equalsIgnoreCase(organizationName)) {
                                    for (String posUuid : myPositions) {
                                        memberNames.add(getNameFromUuid(posUuid, unitNumber, proxyLogin));
                                    }
                                }
                            }
                        }

                        System.out.println("****************************");
                        System.out.println("uuid: " + myUuid);
                        System.out.println("Org Name: " + myOrgName);
//                            System.out.println("Unit Number: " + myUnitNumber);
//                        System.out.println("Child Orgs: " + myChildOrg);
                        System.out.println("Org Type: " + myOrgTypes);
                        System.out.println("Positions: " + myPositions);
                        System.out.println("Member Names: " + memberNames);
                        System.out.println("****************************");

                    }
                }



            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getNameFromUuid( String uuidPersonal, String unitNumber, String proxyLogin) {
        OkHttpClient httpClient = loginCred();
        Request request = requestProxyURL("https://wam-membertools-api-stage.churchofjesuschrist.org/api/v4/households?units=" + unitNumber, proxyLogin );
        JsonParser parser = new JsonParser();
        String responseData;
//        String myPositions = "";
        ArrayList<String> myPositions = new ArrayList<String>();

        String memberName = "";

        try (Response response = httpClient.newCall(request).execute()) {
            assert response.body() != null;
            responseData = response.body().string();
            System.out.println("Response String: " + responseData);
            JsonElement jsonElement = parser.parse(responseData);
            System.out.println("Json element to String: " + jsonElement.toString());
            if (jsonElement instanceof JsonObject) {
                System.out.println("JSON Object!");
                System.out.println("Name: " + ((JsonObject) jsonElement).get("name").getAsString());
            } else if (jsonElement instanceof JsonArray) {
                System.out.println("JSON Array!");
//                JsonArray jsonData = new JsonArray(((JsonArray) jsonElement).size());
                JsonArray jsonData = jsonElement.getAsJsonArray();

                for (JsonElement orgName : jsonData) {
                    JsonObject orgObject = orgName.getAsJsonObject();
                    String myUuid = orgObject.get("uuid").getAsString();
//                    String myOrgName = orgObject.get("displayName").getAsString();

                    if (myUuid.equalsIgnoreCase(uuidPersonal)) {
                        memberName = orgObject.get("displayName").getAsString();

                        System.out.println("****************************");
                        System.out.println("uuid: " + myUuid);
                        System.out.println("Member Name: " + memberName);
                        System.out.println("****************************");
                    }

//                    if (orgObject.has("members")) {
//                        JsonArray positionsArray = orgObject.getAsJsonArray("uuid");
//                        for (JsonElement posElement : positionsArray ) {
////                        JsonObject orgPos = posElement.getAsJsonObject();
//                            myPositions.add(posElement.getAsString());
//                            if (uuidPersonal.equalsIgnoreCase(posElement.getAsString())) {
//                                memberName = orgObject.get("displayName").getAsString();
//                            }
//                        }
//                    }





                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return memberName;

    }




//    //Test Request
//    public void apiRequest() {
//        OkHttpClient httpClient = loginCred();
//        Request request = requestURL();
//        String jsonData;
//
//        try (Response response = httpClient.newCall(request).execute()) {
//            jsonData = response.body().string();
//            System.out.println(jsonData);
//            JsonObject jsonObject = (new JsonParser()).parse(jsonData).getAsJsonObject();
//            System.out.println("Name: " + jsonObject.get("name").getAsString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


//    public void toolsService() throws Exception {
//        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
//        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//        String jsonData;
//
//        byte[] decodeBytes = Base64.decodeBase64("UDFrQFNwMTc=");
//
//        TestWam2CredentialsManager credentialsManager = new TestWam2CredentialsManager("zmaxfield", new String(decodeBytes));
//
//        OkHttpClient httpClient = new OkHttpClient.Builder()
//                .addInterceptor(new TestAuthenticationInterceptor(new TestAuthenticationManager(credentialsManager)))
//                .addInterceptor(loggingInterceptor)
//                .connectTimeout(Duration.ofSeconds(360))
//                .writeTimeout(Duration.ofSeconds(360))
//                .readTimeout(Duration.ofSeconds(360))
//                .build();
//
//
//        Request request = new Request.Builder()
//                .url("https://wam-membertools-api-stage.churchofjesuschrist.org/api/v4/organizations?units=111856")
////                .url("https://identity-util-service-int.churchofjesuschrist.org/api/checkSession")
////                .url("https://wam-membertools-api-stage.churchofjesuschrist.org/api/v4/user")
//                .build();
//
//        try (Response response = httpClient.newCall(request).execute()) {
//            jsonData = response.body().string();
//            System.out.println(jsonData);
//            JsonObject jsonObject = (new JsonParser()).parse(jsonData).getAsJsonObject();
//            System.out.println("Name: " + jsonObject.get("name").getAsString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }




}
