package LDSToolsAppium.API;

import LDSToolsAppium.API.TestAuthenticationInterceptor;
import LDSToolsAppium.API.TestAuthenticationManager;
import LDSToolsAppium.API.TestWam2CredentialsManager;
import com.google.gson.reflect.TypeToken;
import com.google.gson.*;

import okhttp3.*;
import okhttp3.logging.HttpLoggingInterceptor;


import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Stream;

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

    public List<String> getChildOrganizationMembers(String organizationName, String proxyLogin, String unitNumber) throws Exception {
        JsonParser parser = new JsonParser();
        String responseData;
        Gson gson = new Gson();

        ArrayList<String> memberNames = new ArrayList<String>();

        Type apiOrganizationList = new TypeToken<ArrayList<ApiOrganization>>(){}.getType();

        responseData = getOrganizationJson(unitNumber, proxyLogin);
//            System.out.println("Response String: " + responseData);
        JsonElement jsonElement = parser.parse(responseData);
//            System.out.println("Json element to String ORG: " + jsonElement.toString());
        if (jsonElement instanceof JsonObject) {
            System.out.println("JSON Object!");
            System.out.println("Name: " + ((JsonObject) jsonElement).get("name").getAsString());
        } else if (jsonElement instanceof JsonArray) {
//                System.out.println("JSON Array!");
            JsonArray jsonData = jsonElement.getAsJsonArray();
            List<ApiOrganization> testOrg = gson.fromJson(jsonElement, apiOrganizationList);

            for (ApiOrganization myOrg : testOrg) {
//                    System.out.println("Organizations: " + myOrg.getName());
                if (myOrg.getChildOrgs() != null) {
                    for (ChildOrg childOrgs : myOrg.getChildOrgs()) {
//                            System.out.println("Child Org: " + childOrgs.getName());
                        if (childOrgs.getName().equalsIgnoreCase(organizationName)) {
//                                System.out.println("Found - " + organizationName);
                            if (childOrgs.getPositions() != null ) {
//                                    System.out.println("Positions: " + childOrgs.getPositions());
                                for (String onePosition : childOrgs.getPositions()) {
                                    memberNames.add(getNameFromUuid(onePosition, unitNumber, proxyLogin));
                                }

                            }
                        }
                    }
                }
            }
        }

        return memberNames;

    }

    //This is for 2nd level child orgs like - Priests Quorum Presidency
    public List<String> getChild2OrganizationMembers(String organizationName, String proxyLogin, String unitNumber) throws Exception {
        JsonParser parser = new JsonParser();
        String responseData;
        Gson gson = new Gson();

        ArrayList<String> memberNames = new ArrayList<String>();

        Type apiOrganizationList = new TypeToken<ArrayList<ApiOrganization>>(){}.getType();

        responseData = getOrganizationJson(unitNumber, proxyLogin);
//            System.out.println("Response String: " + responseData);
        JsonElement jsonElement = parser.parse(responseData);
//            System.out.println("Json element to String ORG: " + jsonElement.toString());
        if (jsonElement instanceof JsonObject) {
            System.out.println("JSON Object!");
            System.out.println("Name: " + ((JsonObject) jsonElement).get("name").getAsString());
        } else if (jsonElement instanceof JsonArray) {
//                System.out.println("JSON Array!");
            JsonArray jsonData = jsonElement.getAsJsonArray();
            List<ApiOrganization> testOrg = gson.fromJson(jsonElement, apiOrganizationList);

            for (ApiOrganization myOrg : testOrg) {
//                    System.out.println("Organizations: " + myOrg.getName());
                if (myOrg.getChildOrgs() != null) {
                    for (ChildOrg childOrgs : myOrg.getChildOrgs()) {
//                        System.out.println("Child Org: " + childOrgs.getName());
                        if (childOrgs.getChildOrgs() != null) {
                            for (ChildOrg_ childOrgs2 : childOrgs.getChildOrgs()) {
//                                System.out.println("Child Org 2: " + childOrgs2.getName());
                                if (childOrgs2.getName().equalsIgnoreCase(organizationName)) {
//                                    System.out.println("Found - " + organizationName);
                                    if (childOrgs2.getPositions() != null ) {
//                                        System.out.println("Positions: " + childOrgs2.getPositions());
                                        for (String onePosition : childOrgs2.getPositions()) {
                                            memberNames.add(getNameFromUuid(onePosition, unitNumber, proxyLogin));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return memberNames;

    }

    public List<String> getChildOrganizationClasses(String organizationName, String proxyLogin, String unitNumber) throws Exception {
        JsonParser parser = new JsonParser();
        String responseData;
        Gson gson = new Gson();

        ArrayList<String> memberNames = new ArrayList<String>();

        Type apiOrganizationList = new TypeToken<ArrayList<ApiOrganization>>(){}.getType();

        responseData = getOrganizationJson(unitNumber, proxyLogin);
//            System.out.println("Response String: " + responseData);
        JsonElement jsonElement = parser.parse(responseData);
//            System.out.println("Json element to String ORG: " + jsonElement.toString());
        if (jsonElement instanceof JsonObject) {
            System.out.println("JSON Object!");
            System.out.println("Name: " + ((JsonObject) jsonElement).get("name").getAsString());
        } else if (jsonElement instanceof JsonArray) {
//                System.out.println("JSON Array!");
            JsonArray jsonData = jsonElement.getAsJsonArray();
            List<ApiOrganization> testOrg = gson.fromJson(jsonElement, apiOrganizationList);

            for (ApiOrganization myOrg : testOrg) {
//                System.out.println("Organizations: " + myOrg.getName());
                if (myOrg.getName().equalsIgnoreCase(organizationName)) {
                    if (myOrg.getChildOrgs() != null) {
                        for (ChildOrg childOrgs : myOrg.getChildOrgs()) {
//                            System.out.println("Child Org: " + childOrgs.getName());
                            memberNames.add(childOrgs.getName());
                        }
                    }
                }
            }
        }

        return memberNames;

    }


    //TODO: Need a file check for the date then delete if older than 3 or so days? 
    public String getOrganizationJson (String unitNumber, String proxyLogin) throws IOException {
        String responseData = "";
        File organizationFile = new File("ConfigFiles/organization.json");
        StringBuilder contentBuilder = new StringBuilder();

        OkHttpClient httpClient = loginCred();
        Request request = requestProxyURL("https://wam-membertools-api-stage.churchofjesuschrist.org/api/v4/organizations?units="+ unitNumber, proxyLogin );

        if (!organizationFile.exists()) {
            try (Response response = httpClient.newCall(request).execute()) {
                assert response.body() != null;
                responseData = response.body().string();
                try  {
//                    FileWriter myWriter = new FileWriter("organization.json");
                    FileWriter myWriter = new FileWriter(organizationFile);
                    myWriter.write(responseData);
                    myWriter.flush();

                } catch (IOException e) {
                    e.printStackTrace();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                responseData = new String(Files.readAllBytes(Paths.get("ConfigFiles/organization.json")), StandardCharsets.UTF_8);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return responseData;
    }



    public String getHouseholdJson (String unitNumber, String proxyLogin) throws IOException {
        String responseData = "";
        File householdFile = new File("ConfigFiles/households.json");
        StringBuilder contentBuilder = new StringBuilder();

        OkHttpClient httpClient = loginCred();
        Request request = requestProxyURL("https://wam-membertools-api-stage.churchofjesuschrist.org/api/v4/households?units=" + unitNumber, proxyLogin );


        if (!householdFile.exists()) {
            try (Response response = httpClient.newCall(request).execute()) {
                assert response.body() != null;
                responseData = response.body().string();
                try  {
                    FileWriter myWriter = new FileWriter(householdFile);
                    myWriter.write(responseData);
                    myWriter.flush();

                } catch (IOException e) {
                    e.printStackTrace();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                responseData = new String(Files.readAllBytes(Paths.get("ConfigFiles/households.json")), StandardCharsets.UTF_8);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return responseData;
    }



    public String getNameFromUuid( String uuidPersonal, String unitNumber, String proxyLogin) throws IOException {
        OkHttpClient httpClient = loginCred();
        Request request = requestProxyURL("https://wam-membertools-api-stage.churchofjesuschrist.org/api/v4/households?units=" + unitNumber, proxyLogin );
        JsonParser parser = new JsonParser();
        String responseData;
//        String myPositions = "";
        ArrayList<String> myPositions = new ArrayList<String>();
        Gson gson = new Gson();

        Type apiHousehold = new TypeToken<ArrayList<ApiHousehold>>(){}.getType();

        String memberName = "";

        responseData = getHouseholdJson(unitNumber, proxyLogin);

//        System.out.println("Response String: " + responseData);
        JsonElement jsonElement = parser.parse(responseData);
//        System.out.println("Json element to String GET NAME FROM UUID: " + jsonElement.toString());
        if (jsonElement instanceof JsonObject) {
//            System.out.println("JSON Object!");
//            System.out.println("Name: " + ((JsonObject) jsonElement).get("name").getAsString());
        } else if (jsonElement instanceof JsonArray) {
//            System.out.println("JSON Array!");
            JsonArray jsonData = jsonElement.getAsJsonArray();
            List<ApiHousehold> testHouseHold = gson.fromJson(jsonElement, apiHousehold);

            for (ApiHousehold household : testHouseHold) {
//                    System.out.println(household.getDisplayName());
//                    System.out.println(household.getUuid());
                for (Member searchForMember : household.getMembers()) {
//                        System.out.println("Household: uuid - Search For Member: " + searchForMember.getUuid());
//                        System.out.println("Household: Display Name - Search For Member: " + searchForMember.getDisplayName());
//                        System.out.println("Household: SEARCH FOR: " + uuidPersonal);
                    for (Member personalMember : household.getMembers()) {
//                        System.out.println("Personal: SEARCH FOR: " + uuidPersonal);
//                        System.out.println("Personal: uuid: " + personalMember.getUuid());
//                        System.out.println("Personal: Display Name: " + personalMember.getDisplayName());
//                        System.out.println("Positions uuid: " + personalMember.getPositions());
                        if (personalMember.getPositions() != null ) {
                            for (Position onePosition : personalMember.getPositions()) {
//                                System.out.println("Positions uuid: " + onePosition.getUuid());
//                                System.out.println("##### Position Name: " + onePosition.getName());
                                if (onePosition.getUuid().equalsIgnoreCase(uuidPersonal)) {
                                    memberName = personalMember.getDisplayName();
//                                    System.out.println("*******Found*******" + memberName);
                                }
                            }
                        }
                    }
                }
            }
        }


        return memberName;

    }

//
//    public void getOrganizationMember2(String organizationName, String proxyLogin, String unitNumber) {
//        OkHttpClient httpClient = loginCred();
//        Request request = requestProxyURL("https://wam-membertools-api-stage.churchofjesuschrist.org/api/v4/organizations?units=" + unitNumber, proxyLogin );
//        JsonParser parser = new JsonParser();
//        String responseData;
////        String myPositions = "";
//        ArrayList<String> myPositions = new ArrayList<String>();
//        ArrayList<String> memberNames = new ArrayList<String>();
//
//
//        try (Response response = httpClient.newCall(request).execute()) {
//            assert response.body() != null;
//            responseData = response.body().string();
//            System.out.println("Response String: " + responseData);
//            JsonElement jsonElement = parser.parse(responseData);
//            System.out.println("Json element to String: " + jsonElement.toString());
//            if (jsonElement instanceof JsonObject) {
//                System.out.println("JSON Object!");
//                System.out.println("Name: " + ((JsonObject) jsonElement).get("name").getAsString());
//            } else if (jsonElement instanceof JsonArray) {
//                System.out.println("JSON Array!");
////                JsonArray jsonData = new JsonArray(((JsonArray) jsonElement).size());
////                JsonArray jsonData = jsonElement.getAsJsonArray();
//                JsonArray jsonData = jsonElement.getAsJsonArray();
//
//                for (JsonElement orgName : jsonData) {
//                    JsonObject orgObject = orgName.getAsJsonObject();
//                    String myUuid = orgObject.get("uuid").getAsString();
//                    String myOrgName = orgObject.get("name").getAsString();
//                    String myOrgTypes = orgObject.get("orgTypes").getAsString();
//                    if (organizationName.equalsIgnoreCase(myOrgName)) {
//                        if (orgObject.has("positions")) {
//                            JsonArray positionsArray = orgObject.getAsJsonArray("positions");
//                            for (JsonElement posElement : positionsArray ) {
//                                myPositions.add(posElement.getAsString());
//                                if (myOrgName.equalsIgnoreCase(organizationName)) {
//                                    for (String posUuid : myPositions) {
//                                        memberNames.add(getNameFromUuid(posUuid, unitNumber, proxyLogin));
//                                    }
//                                }
//                            }
//                        }
//
//                        System.out.println("****************************");
//                        System.out.println("uuid: " + myUuid);
//                        System.out.println("Org Name: " + myOrgName);
////                            System.out.println("Unit Number: " + myUnitNumber);
////                        System.out.println("Child Orgs: " + myChildOrg);
//                        System.out.println("Org Type: " + myOrgTypes);
//                        System.out.println("Positions: " + myPositions);
//                        System.out.println("Member Names: " + memberNames);
//                        System.out.println("****************************");
//
//                    }
//                }
//
//
//
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//

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
