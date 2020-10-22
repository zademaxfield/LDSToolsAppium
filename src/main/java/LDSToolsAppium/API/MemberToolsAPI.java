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
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class MemberToolsAPI {

    Response householdAPI = null;


    //Login credentials for the API
    public OkHttpClient loginCred() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);


//        // Encode data on your side using BASE64
//        byte[] bytesEncoded = Base64.encodeBase64(str.getBytes());
//        System.out.println("encoded value is " + new String(bytesEncoded));
//
//        // Decode data on other side, by processing encoded data
//        byte[] valueDecoded = Base64.decodeBase64(bytesEncoded);
//        System.out.println("Decoded value is " + new String(valueDecoded));


        byte[] decodeBytes = Base64.decodeBase64("QkBiMDBuU3AxNzIwMjA=");

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
//        proxyUser = "kroqbandit";
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

    public List<String> getOrganizationMembers(String organizationName, String proxyLogin, String unitNumber) throws Exception {
        proxyLogin = "kroqbandit";
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
                    for (String onePosition : myOrg.getPositions()) {
                        memberNames.add(getNameFromUuid(onePosition, unitNumber, proxyLogin, "position"));
                    }
                }
            }
        }

        return memberNames;

    }

    public List<String> getChildOrganizationMembers(String organizationName, String proxyLogin, String unitNumber) throws Exception {
        proxyLogin = "kroqbandit";
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
                                    memberNames.add(getNameFromUuid(onePosition, unitNumber, proxyLogin, "position"));
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
        proxyLogin = "kroqbandit";
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
                                            memberNames.add(getNameFromUuid(onePosition, unitNumber, proxyLogin, "position"));
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
        proxyLogin = "kroqbandit";
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
        proxyLogin = "kroqbandit";
        String responseData = "";
        File organizationFile = new File("ConfigFiles/organization" + unitNumber + ".json");
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
                responseData = new String(Files.readAllBytes(Paths.get("ConfigFiles/organization" + unitNumber + ".json")), StandardCharsets.UTF_8);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return responseData;
    }



    public String getHouseholdJson (String unitNumber, String proxyLogin) throws IOException {
        proxyLogin = "kroqbandit";
        String responseData = "";
        File householdFile = new File("ConfigFiles/households" + unitNumber + ".json");
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
                responseData = new String(Files.readAllBytes(Paths.get("ConfigFiles/households" + unitNumber + ".json")), StandardCharsets.UTF_8);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return responseData;
    }


    //TODO: Need a file check for the date then delete if older than 3 or so days?
    public String getReportJson (String unitNumber, String proxyLogin) throws IOException {
        proxyLogin = "kroqbandit";
        String responseData = "";
        File organizationFile = new File("ConfigFiles/reports" + unitNumber + ".json");
        StringBuilder contentBuilder = new StringBuilder();

        OkHttpClient httpClient = loginCred();
        Request request = requestProxyURL("https://wam-membertools-api-stage.churchofjesuschrist.org/api/v4/reports?units="+ unitNumber, proxyLogin );

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
                responseData = new String(Files.readAllBytes(Paths.get("ConfigFiles/reports" + unitNumber + ".json")), StandardCharsets.UTF_8);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return responseData;
    }

    //TODO: Need a file check for the date then delete if older than 3 or so days?
    public String getReportUnitStatsJson (String unitNumber, String proxyLogin) throws IOException {
        proxyLogin = "kroqbandit";
        String responseData = "";
        File organizationFile = new File("ConfigFiles/reportsUnitStats" + unitNumber + ".json");
        StringBuilder contentBuilder = new StringBuilder();

        OkHttpClient httpClient = loginCred();
        Request request = requestProxyURL("https://wam-membertools-api-stage.churchofjesuschrist.org/api/v4/reports/unit-statistics?units="+ unitNumber, proxyLogin );

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
                responseData = new String(Files.readAllBytes(Paths.get("ConfigFiles/reportsUnitStats" + unitNumber + ".json")), StandardCharsets.UTF_8);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return responseData;
    }

    //TODO: Need a file check for the date then delete if older than 3 or so days?
    public String getReportsActionAndInterview(String unitNumber, String proxyLogin) throws IOException {
        proxyLogin = "kroqbandit";
        String responseData = "";
        File organizationFile = new File("ConfigFiles/reportsActionAndInterview" + unitNumber + ".json");
        StringBuilder contentBuilder = new StringBuilder();

        OkHttpClient httpClient = loginCred();
        Request request = requestProxyURL("https://wam-membertools-api-stage.churchofjesuschrist.org/api/v4/reports/action-interviews?units="+ unitNumber, proxyLogin );

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
                responseData = new String(Files.readAllBytes(Paths.get("ConfigFiles/reportsActionAndInterview" + unitNumber + ".json")), StandardCharsets.UTF_8);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return responseData;
    }

    //TODO: Need a file check for the date then delete if older than 3 or so days?
    public String getMissionaryJson (String unitNumber, String proxyLogin) throws IOException {
        proxyLogin = "kroqbandit";
        String responseData = "";
        File organizationFile = new File("ConfigFiles/missionary" + unitNumber + ".json");
        StringBuilder contentBuilder = new StringBuilder();

        OkHttpClient httpClient = loginCred();
        Request request = requestProxyURL("https://wam-membertools-api-stage.churchofjesuschrist.org/api/v4/missionaries?units="+ unitNumber, proxyLogin );

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
                responseData = new String(Files.readAllBytes(Paths.get("ConfigFiles/missionary" + unitNumber + ".json")), StandardCharsets.UTF_8);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return responseData;
    }


    //TODO: Need a file check for the date then delete if older than 3 or so days?
    public String getCovenantPathJson(String unitNumber, String proxyLogin) throws IOException {
        String responseData = "";
        File organizationFile = new File("ConfigFiles/covenantPath" + unitNumber + ".json");
        StringBuilder contentBuilder = new StringBuilder();

        OkHttpClient httpClient = loginCred();
        Request request = requestProxyURL("https://wam-membertools-api-stage.churchofjesuschrist.org/api/v4/covenant-path?units="+ unitNumber, proxyLogin );

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
                responseData = new String(Files.readAllBytes(Paths.get("ConfigFiles/covenantPath" + unitNumber + ".json")), StandardCharsets.UTF_8);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return responseData;
    }


    public List<String> getCovenantPathNames(String proxyLogin, String unitNumber, String progressRecordType) throws Exception {
        JsonParser parser = new JsonParser();
        String responseData;
        Gson gson = new Gson();
        ApiCovenantPath myCovenantPath = new ApiCovenantPath();
        ArrayList<String> memberNames = new ArrayList<String>();
        Type apiCovenantPath = new TypeToken<ArrayList<ApiCovenantPath>>(){}.getType();
        responseData = getCovenantPathJson(unitNumber, proxyLogin);
//        System.out.println("Response String: " + responseData);
        JsonElement jsonElement = parser.parse(responseData);

        if (jsonElement instanceof JsonObject) {
//            System.out.println("JSON Object!");
            myCovenantPath = gson.fromJson(jsonElement, ApiCovenantPath.class);


        } else if (jsonElement instanceof JsonArray) {
//            System.out.println("JSON Array!");
            JsonArray jsonData = jsonElement.getAsJsonArray();
            List<ApiCovenantPath> testCovenantPath = gson.fromJson(jsonElement, apiCovenantPath);
            for(ApiCovenantPath name : testCovenantPath) {
                if (progressRecordType.contains("new")) {
                    if (name.getStatus().equalsIgnoreCase("NEW_MEMBER")) {
                        memberNames.add(name.getDisplayName());
                    }
                } else {
                    if (!name.getStatus().equalsIgnoreCase("NEW_MEMBER")) {
                        memberNames.add(name.getDisplayName());
                    }
                }
            }
        }

        return memberNames;
    }


    public List<String> getCovenantPathUserDetails(String proxyLogin, String unitNumber, String userName) throws Exception {
        JsonParser parser = new JsonParser();
        String responseData;
        Gson gson = new Gson();
        ApiCovenantPath myCovenantPath = new ApiCovenantPath();
        ArrayList<String> memberNames = new ArrayList<String>();
        Type apiCovenantPath = new TypeToken<ArrayList<ApiCovenantPath>>(){}.getType();
        responseData = getCovenantPathJson(unitNumber, proxyLogin);
//        System.out.println("Response String: " + responseData);
        JsonElement jsonElement = parser.parse(responseData);

        if (jsonElement instanceof JsonObject) {
//            System.out.println("JSON Object!");
            myCovenantPath = gson.fromJson(jsonElement, ApiCovenantPath.class);


        } else if (jsonElement instanceof JsonArray) {
//            System.out.println("JSON Array!");
            JsonArray jsonData = jsonElement.getAsJsonArray();
            List<ApiCovenantPath> testCovenantPath = gson.fromJson(jsonElement, apiCovenantPath);
            for(ApiCovenantPath name : testCovenantPath) {
                if (name.getDisplayName().equalsIgnoreCase(userName)) {
                    System.out.println("Name: " + name.getDisplayName());
                    System.out.println("Sac Missed: " + name.getSacramentMeetingsMissed());
                    System.out.println("Baptism Goal Date: " + name.getBaptismGoalDate());
                    System.out.println("Confirmation Date: " + name.getConfirmationDate());
                    System.out.println("Endowment Eligibility Date: " + name.getEndowmentEligibilityDate());
                    System.out.println("First Taught: " + name.getFirstTaught());
                    System.out.println("Friends Display: " + name.getFriendsDisplay());
                    System.out.println("Status: " + name.getStatus());
                    System.out.println("Address: " + name.getAddress());
                    System.out.println("Opted Out: " + name.getOptedOut());
                    System.out.println("Sort Name: " + name.getSortName());
                    System.out.println("Next Appointment: " + name.getNextAppointment());
                    System.out.println("Priesthood Eligibility: " + name.getPriesthoodEligibility());
                    System.out.println("Sealed to Parents: " + name.getSealedToParents());
                    System.out.println("Sealed to Spouse: " + name.getSealedToSpouse());
                }
            }
        }

        return memberNames;
    }

    public int getCovenantPathUserSacramentMissed(String proxyLogin, String unitNumber, String userName) throws Exception {
        JsonParser parser = new JsonParser();
        String responseData;
        Gson gson = new Gson();
        ApiCovenantPath myCovenantPath = new ApiCovenantPath();
        ArrayList<String> memberNames = new ArrayList<String>();
        Type apiCovenantPath = new TypeToken<ArrayList<ApiCovenantPath>>(){}.getType();
        responseData = getCovenantPathJson(unitNumber, proxyLogin);
//        System.out.println("Response String: " + responseData);
        JsonElement jsonElement = parser.parse(responseData);
        int sacramentMissed = 0;

        if (jsonElement instanceof JsonObject) {
//            System.out.println("JSON Object!");
            myCovenantPath = gson.fromJson(jsonElement, ApiCovenantPath.class);


        } else if (jsonElement instanceof JsonArray) {
//            System.out.println("JSON Array!");
            JsonArray jsonData = jsonElement.getAsJsonArray();
            List<ApiCovenantPath> testCovenantPath = gson.fromJson(jsonElement, apiCovenantPath);
            for(ApiCovenantPath name : testCovenantPath) {
                if (name.getDisplayName().equalsIgnoreCase(userName)) {
                    System.out.println("Sac Missed: " + name.getSacramentMeetingsMissed());
                    sacramentMissed = name.getSacramentMeetingsMissed();
                }
            }
        }

        return sacramentMissed;
    }




    public String getNameFromUuid( String uuidPersonal, String unitNumber, String proxyLogin, String returnType) throws IOException {
        proxyLogin = "kroqbandit";
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
                        if (returnType.equalsIgnoreCase("personal")) {
                            if (personalMember.getUuid().equalsIgnoreCase(uuidPersonal)) {
                                memberName = personalMember.getDisplayName();
                            }
                        }
                        if (personalMember.getPositions() != null ) {
                            for (Position onePosition : personalMember.getPositions()) {
//                                System.out.println("Positions uuid: " + onePosition.getUuid());
//                                System.out.println("##### Position Name: " + onePosition.getName());
                                if (returnType.equalsIgnoreCase("position")) {
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
        }


        return memberName;

    }


    //This will return a list of reports
    public List<String> getReportNames(String proxyLogin, String unitNumber) throws Exception {
//        proxyLogin = "kroqbandit";
//        unitNumber = "21628";
        JsonParser parser = new JsonParser();
        String responseData;
        Gson gson = new Gson();
        ApiReports myReport = new ApiReports();

        ArrayList<String> memberNames = new ArrayList<String>();

        Type apiReportList = new TypeToken<ArrayList<ApiReports>>(){}.getType();

        responseData = getReportJson(unitNumber, proxyLogin);
//        System.out.println("Response String: " + responseData);
        JsonElement jsonElement = parser.parse(responseData);

        if (jsonElement instanceof JsonObject) {
//            System.out.println("JSON Object!");
            myReport = gson.fromJson(jsonElement, ApiReports.class);

            for (ReportUnit access : myReport.getAccess().getUnits()) {
//                System.out.println("Unit Number : " + access.getUnitNumber().toString());
//                System.out.println("Reports : " + access.getReports().toString());
                for (Object listReportName : access.getReports().toArray()) {
//                    System.out.println("One Report: " + listReportName.toString());
                    memberNames.add(listReportName.toString());
                }
            }


        } else if (jsonElement instanceof JsonArray) {
            System.out.println("JSON Array!");
            JsonArray jsonData = jsonElement.getAsJsonArray();
            List<ApiReports> testReport = gson.fromJson(jsonElement, apiReportList);

        }


        return memberNames;

    }

    public List<String> getNamesFromActionInterviewReports(String reportName, String proxyLogin, String unitNumber) throws Exception {
        proxyLogin = "kroqbandit";
        JsonParser parser = new JsonParser();
        String responseData;
        Gson gson = new Gson();
        ApiReports myReport = new ApiReports();

        ArrayList<String> memberNames = new ArrayList<String>();

        Type apiReportList = new TypeToken<ArrayList<ApiReports>>(){}.getType();

        responseData = getReportJson(unitNumber, proxyLogin);
//        System.out.println("Response String: " + responseData);
        JsonElement jsonElement = parser.parse(responseData);


//            System.out.println("Json element to String ORG: " + jsonElement.toString());
        if (jsonElement instanceof JsonObject) {
//            System.out.println("JSON Object!");
            myReport = gson.fromJson(jsonElement, ApiReports.class);


            for (ReportActionInterview actionInterview : myReport.getActionInterviews()) {
//                System.out.println("Unit Number: " + actionInterview.getUnitNumber().toString());
//                System.out.println("Name: " + actionInterview.getName());
//                System.out.println("Description: " + actionInterview.getDescription());
//                System.out.println("Type: " + actionInterview.getType());
//                System.out.println("Members: " + actionInterview.getMembers().toString());
                if (actionInterview.getName().contains(reportName)) {
                    for (Member myMembers : actionInterview.getMembers()) {
//                        System.out.println("One Member: " + myMembers.getUuid());
//                        System.out.println("One Member Name: " + getNameFromUuid( myMembers.getUuid(), unitNumber, proxyLogin, "personal"));
                        memberNames.add(getNameFromUuid( myMembers.getUuid(), unitNumber, proxyLogin, "personal"));
                    }
                }
            }

        } else if (jsonElement instanceof JsonArray) {
//                System.out.println("JSON Array!");
            JsonArray jsonData = jsonElement.getAsJsonArray();
            List<ApiReports> testReport = gson.fromJson(jsonElement, apiReportList);

        }


        return memberNames;

    }

    public List<String> getNamesFromMembersMovedOut(String proxyLogin, String unitNumber) throws Exception {
        proxyLogin = "kroqbandit";
        JsonParser parser = new JsonParser();
        String responseData;
        Gson gson = new Gson();
        ApiReports myReport = new ApiReports();

        ArrayList<String> memberNames = new ArrayList<String>();

        Type apiReportList = new TypeToken<ArrayList<ApiReports>>(){}.getType();

        responseData = getReportJson(unitNumber, proxyLogin);
//        System.out.println("Response String: " + responseData);
        JsonElement jsonElement = parser.parse(responseData);


//            System.out.println("Json element to String ORG: " + jsonElement.toString());
        if (jsonElement instanceof JsonObject) {
//            System.out.println("JSON Object!");
            myReport = gson.fromJson(jsonElement, ApiReports.class);


            for (ReportMembersMovedOut membersMovedOut : myReport.getMembersMovedOut()) {
//                System.out.println("Unit Number: " + membersMovedOut.getUnitNumber().toString());
//                System.out.println("Display Name: " + membersMovedOut.getDisplayName());
//                System.out.println("Moved Out Date: " + membersMovedOut.getPriorUnitMoveOutDate());
//                System.out.println("Next Unit: " + membersMovedOut.getNextUnit());
//                System.out.println("Members: " + actionInterview.getMembers().toString());
                memberNames.add(membersMovedOut.getDisplayName());

            }

        } else if (jsonElement instanceof JsonArray) {
//                System.out.println("JSON Array!");
            JsonArray jsonData = jsonElement.getAsJsonArray();
            List<ApiReports> testReport = gson.fromJson(jsonElement, apiReportList);

        }


        return memberNames;

    }

    public List<String> getNamesTempleRecommendStatusActive(String proxyLogin, String unitNumber) throws Exception {
        proxyLogin = "kroqbandit";
        JsonParser parser = new JsonParser();
        String responseData;
        Gson gson = new Gson();
        ApiReports myReport = new ApiReports();

        ArrayList<String> memberNames = new ArrayList<String>();

        Type apiReportList = new TypeToken<ArrayList<ApiReports>>(){}.getType();

        responseData = getReportJson(unitNumber, proxyLogin);
//        System.out.println("Response String: " + responseData);
        JsonElement jsonElement = parser.parse(responseData);


//            System.out.println("Json element to String ORG: " + jsonElement.toString());
        if (jsonElement instanceof JsonObject) {
//            System.out.println("JSON Object!");
            myReport = gson.fromJson(jsonElement, ApiReports.class);

            for (ReportUnitStatistic myUnitStats : myReport.getUnitStatistics()) {
//                System.out.println("Unit Number: " + myUnitStats.getEndowedWithRecommendUuids().toString());
                for (String memberList : myUnitStats.getEndowedWithRecommendUuids()) {
                    memberNames.add(getNameFromUuid( memberList, unitNumber, proxyLogin, "personal"));
//                    memberNames.add(memberList);
                    Collections.sort(memberNames);
                }
            }

        } else if (jsonElement instanceof JsonArray) {
//                System.out.println("JSON Array!");
            JsonArray jsonData = jsonElement.getAsJsonArray();
            List<ApiReports> testReport = gson.fromJson(jsonElement, apiReportList);

        }

        return memberNames;

    }

    public List<String> getNamesTempleRecommendStatusAll(String proxyLogin, String unitNumber) throws Exception {
        proxyLogin = "kroqbandit";
        JsonParser parser = new JsonParser();
        String responseData;
        Gson gson = new Gson();
        ApiReports myReport = new ApiReports();

        ArrayList<String> memberNames = new ArrayList<String>();

        Type apiReportList = new TypeToken<ArrayList<ApiReports>>(){}.getType();

        responseData = getReportJson(unitNumber, proxyLogin);
//        System.out.println("Response String: " + responseData);
        JsonElement jsonElement = parser.parse(responseData);


//            System.out.println("Json element to String ORG: " + jsonElement.toString());
        if (jsonElement instanceof JsonObject) {
//            System.out.println("JSON Object!");
            myReport = gson.fromJson(jsonElement, ApiReports.class);

            for (ReportUnitStatistic myUnitStats : myReport.getUnitStatistics()) {
//                System.out.println("Unit Number: " + myUnitStats.getEndowedWithRecommendUuids().toString());
                for (String memberList : myUnitStats.getEndowedAdultsUuids()) {
                    memberNames.add(getNameFromUuid( memberList, unitNumber, proxyLogin, "personal"));
//                    memberNames.add(memberList);
                    Collections.sort(memberNames);
                }
            }

        } else if (jsonElement instanceof JsonArray) {
//                System.out.println("JSON Array!");
            JsonArray jsonData = jsonElement.getAsJsonArray();
            List<ApiReports> testReport = gson.fromJson(jsonElement, apiReportList);

        }

        return memberNames;

    }

    public List<String> getNewMembers(String proxyLogin, String unitNumber) throws Exception {
        proxyLogin = "kroqbandit";
        JsonParser parser = new JsonParser();
        String responseData;
        Gson gson = new Gson();
        ApiReports myReport = new ApiReports();

        ArrayList<String> memberNames = new ArrayList<String>();

        Type apiReportList = new TypeToken<ArrayList<ApiReports>>(){}.getType();

        responseData = getReportJson(unitNumber, proxyLogin);
//        System.out.println("Response String: " + responseData);
        JsonElement jsonElement = parser.parse(responseData);


//            System.out.println("Json element to String ORG: " + jsonElement.toString());
        if (jsonElement instanceof JsonObject) {
//            System.out.println("JSON Object!");
            myReport = gson.fromJson(jsonElement, ApiReports.class);


            for (ReportNewMember myNewMember : myReport.getNewMembers()) {
                memberNames.add(getNameFromUuid( myNewMember.getUuid(), unitNumber, proxyLogin, "personal"));
            }

        } else if (jsonElement instanceof JsonArray) {
//                System.out.println("JSON Array!");
            JsonArray jsonData = jsonElement.getAsJsonArray();
            List<ApiReports> testReport = gson.fromJson(jsonElement, apiReportList);

        }

        return memberNames;

    }

    public List<String> getNamesFromNewMembers(String proxyLogin, String unitNumber) throws Exception {
        proxyLogin = "kroqbandit";
        JsonParser parser = new JsonParser();
        String responseData;
        Gson gson = new Gson();
        ApiReports myReport = new ApiReports();

        ArrayList<String> memberNames = new ArrayList<String>();

        Type apiReportList = new TypeToken<ArrayList<ApiReports>>(){}.getType();

        responseData = getReportJson(unitNumber, proxyLogin);
//        System.out.println("Response String: " + responseData);
        JsonElement jsonElement = parser.parse(responseData);


//            System.out.println("Json element to String ORG: " + jsonElement.toString());
        if (jsonElement instanceof JsonObject) {
//            System.out.println("JSON Object!");
            myReport = gson.fromJson(jsonElement, ApiReports.class);


            for (ReportNewMember newMember : myReport.getNewMembers()) {
                System.out.println("Unit Number: " + newMember.getUnitNumber().toString());
                System.out.println("Uuid: " + newMember.getUuid());

                memberNames.add(getNameFromUuid( newMember.getUuid(), unitNumber, proxyLogin, "personal"));

            }

        } else if (jsonElement instanceof JsonArray) {
//                System.out.println("JSON Array!");
            JsonArray jsonData = jsonElement.getAsJsonArray();
            List<ApiReports> testReport = gson.fromJson(jsonElement, apiReportList);

        }


        return memberNames;

    }



    public List<String> getInfoFromMinisteringBrothers(String proxyLogin, String unitNumber) throws Exception {
        proxyLogin = "kroqbandit";
        JsonParser parser = new JsonParser();
        String responseData;
        Gson gson = new Gson();
        ApiReports myReport = new ApiReports();

        ArrayList<String> memberNames = new ArrayList<String>();

        Type apiReportList = new TypeToken<ArrayList<ApiReports>>(){}.getType();

        responseData = getReportJson(unitNumber, proxyLogin);
//        System.out.println("Response String: " + responseData);
        JsonElement jsonElement = parser.parse(responseData);


//            System.out.println("Json element to String ORG: " + jsonElement.toString());
        if (jsonElement instanceof JsonObject) {
//            System.out.println("JSON Object!");
            myReport = gson.fromJson(jsonElement, ApiReports.class);


            for (ReportMinisteringBrother ministeringBrother : myReport.getMinisteringBrothers()) {
                System.out.println("Unit Number: " + ministeringBrother.getDistricts().toString());
                for (ReportDistrict myDistrict : ministeringBrother.getDistricts()) {
                    System.out.println("District Name: " + myDistrict.getName());
                    // Send district name
                    if (myDistrict.getCompanionships() != null) {
                        for (ReportCompanionship myCompanionship : myDistrict.getCompanionships()) {
                            System.out.println("Uuid: " + myCompanionship.getUuid());
                            //Send Companionship?
                            System.out.println("Companions: " + myCompanionship.getCompanions());
                            for (ReportCompanion myCompanion : myCompanionship.getCompanions()) {
                                System.out.println("Companion: " + myCompanion.getUuid());
                                memberNames.add(getNameFromUuid( myCompanion.getUuid(), unitNumber, proxyLogin, "personal"));
                                //Send Companion
                            }
                        }
                    }


                }

//                memberNames.add(getNameFromUuid( newMember.getUuid(), unitNumber, proxyLogin, "personal"));

            }

        } else if (jsonElement instanceof JsonArray) {
//                System.out.println("JSON Array!");
            JsonArray jsonData = jsonElement.getAsJsonArray();
            List<ApiReports> testReport = gson.fromJson(jsonElement, apiReportList);

        }


        return memberNames;

    }


    //This will get the first 6 Unit Stat Numbers
    public List<String> getReportUnitStatsNumbers(String proxyLogin, String unitNumber) throws Exception {
        proxyLogin = "kroqbandit";
        JsonParser parser = new JsonParser();
        String responseData;
        Gson gson = new Gson();
        ApiReportUnitStat myReportUnitStats = new ApiReportUnitStat();

        ArrayList<String> memberNames = new ArrayList<String>();

        Type apiReportUnitStat = new TypeToken<ArrayList<ApiReportUnitStat>>(){}.getType();

        responseData = getReportUnitStatsJson(unitNumber, proxyLogin);
//        System.out.println("Response String: " + responseData);
        JsonElement jsonElement = parser.parse(responseData);


//            System.out.println("Json element to String ORG: " + jsonElement.toString());
        if (jsonElement instanceof JsonObject) {
//            System.out.println("JSON Object!");
            myReportUnitStats = gson.fromJson(jsonElement, ApiReportUnitStat.class);



//            for (ReportNewMember newMember : myReportUnitStats.getNewMembers()) {
//                System.out.println("Unit Number: " + newMember.getUnitNumber().toString());
//                System.out.println("Uuid: " + newMember.getUuid());
//
//                memberNames.add(getNameFromUuid( newMember.getUuid(), unitNumber, proxyLogin, "personal"));
//
//            }

        } else if (jsonElement instanceof JsonArray) {
            System.out.println("JSON Array!");
            JsonArray jsonData = jsonElement.getAsJsonArray();
            List<ApiReportUnitStat> testReport = gson.fromJson(jsonElement, apiReportUnitStat);
            for (ApiReportUnitStat reportName : testReport) {
                memberNames.add(reportName.getTotalMembers().toString());
                memberNames.add(reportName.getMen().toString());
                memberNames.add(reportName.getHighPriests().toString());
                memberNames.add(reportName.getElders().toString());
                memberNames.add(reportName.getProspectiveElders().toString());
                memberNames.add(reportName.getWomen().toString());
            }

        }


        return memberNames;

    }

    public List<String> getNamesActionAndInterviewReports(String reportToGet, String proxyLogin, String unitNumber) throws Exception {
        proxyLogin = "kroqbandit";
        JsonParser parser = new JsonParser();
        String responseData;
        Gson gson = new Gson();
        ApiReportActionAndInterview myReportActionAndInterview = new ApiReportActionAndInterview();

        ArrayList<String> memberNames = new ArrayList<String>();

        Type apiReportListActionAndInterview = new TypeToken<ArrayList<ApiReportActionAndInterview>>(){}.getType();

        responseData = getReportsActionAndInterview(unitNumber, proxyLogin);
//        System.out.println("Response String: " + responseData);
        JsonElement jsonElement = parser.parse(responseData);


//            System.out.println("Json element to String ORG: " + jsonElement.toString());
        if (jsonElement instanceof JsonObject) {
//            System.out.println("JSON Object!");
            myReportActionAndInterview = gson.fromJson(jsonElement, ApiReportActionAndInterview.class);


//            System.out.println("Type: " + myReportActionAndInterview.getType());

//            for (ActionAndInterviewMember myMember : myReportActionAndInterview.getMembers()) {
//                System.out.println("Unit Number: " + membersMovedOut.getUnitNumber().toString());
//                System.out.println("Display Name: " + membersMovedOut.getDisplayName());
//                System.out.println("Moved Out Date: " + membersMovedOut.getPriorUnitMoveOutDate());
//                System.out.println("Next Unit: " + membersMovedOut.getNextUnit());
//                System.out.println("Members: " + actionInterview.getMembers().toString());
//                memberNames.add(membersMovedOut.getDisplayName());
//
//            }

        } else if (jsonElement instanceof JsonArray) {
//                System.out.println("JSON Array!");
            JsonArray jsonData = jsonElement.getAsJsonArray();
            List<ApiReportActionAndInterview> testReport = gson.fromJson(jsonElement, apiReportListActionAndInterview);
            for (ApiReportActionAndInterview actionAndInterview : testReport) {
                if (actionAndInterview.getName().equalsIgnoreCase(reportToGet)) {
                    for (ActionAndInterviewMember myMember: actionAndInterview.getMembers()) {
//                        System.out.println("Member: " + myMember.getUuid());
                        memberNames.add(getNameFromUuid( myMember.getUuid(), unitNumber, proxyLogin, "personal"));
                    }
                }
            }
        }


        return memberNames;

    }





    public List<String> getAssignedMissionaries(String proxyLogin, String unitNumber) throws Exception {
        proxyLogin = "kroqbandit";
        JsonParser parser = new JsonParser();
        String responseData;
        Gson gson = new Gson();
        ApiMissionary myMissionary = new ApiMissionary();

        ArrayList<String> memberNames = new ArrayList<String>();

//        Type apiReportList = new TypeToken<ArrayList<ApiReports>>(){}.getType();
        Type apiMissionary = new TypeToken<ArrayList<ApiMissionary>>(){}.getType();

        responseData = getMissionaryJson(unitNumber, proxyLogin);

//        System.out.println("Response String: " + responseData);
        JsonElement jsonElement = parser.parse(responseData);


//            System.out.println("Json element to String ORG: " + jsonElement.toString());
        if (jsonElement instanceof JsonObject) {
//            System.out.println("JSON Object!");
            myMissionary = gson.fromJson(jsonElement, ApiMissionary.class);


            for (Assigned assignedMissionary : myMissionary.getAssigned()) {
//                System.out.println("Assigned: " + assignedMissionary.getMission().toString() );
//                System.out.println("Unit Numbers: " + assignedMissionary.getUnitNumbers().toString());
//                System.out.println("Area ID: " + assignedMissionary.getAreaId().toString());
//                System.out.println("Email: " + assignedMissionary.getEmail().toString());
//                System.out.println("Phone: " + assignedMissionary.getPhone().toString());

                for (Missionary missionaries : assignedMissionary.getMissionaries()) {
//                    System.out.println("Missionaries Display Name: " + missionaries.getDisplayName());
//                    System.out.println("Missionaries Preferred Name: " + missionaries.getPreferredName());
                    memberNames.add(missionaries.getPreferredName());
                }
//                memberNames.add(assignedMissionary.getMissionaries()));

            }

        } else if (jsonElement instanceof JsonArray) {
//                System.out.println("JSON Array!");
            JsonArray jsonData = jsonElement.getAsJsonArray();
            List<ApiReports> testReport = gson.fromJson(jsonElement, apiMissionary);

        }


        return memberNames;

    }

    public List<String> getServingMissionaries(String proxyLogin, String unitNumber) throws Exception {
        proxyLogin = "kroqbandit";
        JsonParser parser = new JsonParser();
        String responseData;
        Gson gson = new Gson();
        ApiMissionary myMissionary = new ApiMissionary();
        ArrayList<String> memberNames = new ArrayList<String>();
        Type apiMissionary = new TypeToken<ArrayList<ApiMissionary>>(){}.getType();

        responseData = getMissionaryJson(unitNumber, proxyLogin);
        JsonElement jsonElement = parser.parse(responseData);


        if (jsonElement instanceof JsonObject) {
            myMissionary = gson.fromJson(jsonElement, ApiMissionary.class);

            if (myMissionary.getServing() != null) {
                for (Serving servingMissionaries : myMissionary.getServing()) {
//                System.out.println("Display Name: " + servingMissionaries.getDisplayName() );
                    System.out.println("Preferred Name: " + servingMissionaries.getPreferredName());
                    memberNames.add(servingMissionaries.getPreferredName());
                }
            }


        } else if (jsonElement instanceof JsonArray) {
//                System.out.println("JSON Array!");
            JsonArray jsonData = jsonElement.getAsJsonArray();
            List<ApiReports> testReport = gson.fromJson(jsonElement, apiMissionary);

        }


        return memberNames;

    }



}
