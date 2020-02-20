package LDSToolsAppium.API;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApiHousehold {

    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("coordinates")
    @Expose
    private Coordinates coordinates;
    @SerializedName("displayName")
    @Expose
    private String displayName;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("familyName")
    @Expose
    private String familyName;
    @SerializedName("members")
    @Expose
    private List<Member> members = null;
    @SerializedName("permissions")
    @Expose
    private List<String> permissions = null;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("privacy")
    @Expose
    private Privacy_ privacy;
    @SerializedName("removed")
    @Expose
    private Boolean removed;
    @SerializedName("sortName")
    @Expose
    private String sortName;
    @SerializedName("unitNumber")
    @Expose
    private Integer unitNumber;
    @SerializedName("uuid")
    @Expose
    private String uuid;
    @SerializedName("verified")
    @Expose
    private Boolean verified;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Privacy_ getPrivacy() {
        return privacy;
    }

    public void setPrivacy(Privacy_ privacy) {
        this.privacy = privacy;
    }

    public Boolean getRemoved() {
        return removed;
    }

    public void setRemoved(Boolean removed) {
        this.removed = removed;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public Integer getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(Integer unitNumber) {
        this.unitNumber = unitNumber;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

}

class Coordinates {

    @SerializedName("lat")
    @Expose
    private Integer lat;
    @SerializedName("long")
    @Expose
    private Integer _long;

    public Integer getLat() {
        return lat;
    }

    public void setLat(Integer lat) {
        this.lat = lat;
    }

    public Integer getLong() {
        return _long;
    }

    public void setLong(Integer _long) {
        this._long = _long;
    }

}


class Father {

    @SerializedName("birthDate")
    @Expose
    private String birthDate;
    @SerializedName("displayName")
    @Expose
    private String displayName;
    @SerializedName("uuid")
    @Expose
    private String uuid;

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

}


class Marriage {

    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("place")
    @Expose
    private String place;
    @SerializedName("sealingDate")
    @Expose
    private String sealingDate;
    @SerializedName("spouse")
    @Expose
    private Spouse spouse;
    @SerializedName("temple")
    @Expose
    private String temple;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getSealingDate() {
        return sealingDate;
    }

    public void setSealingDate(String sealingDate) {
        this.sealingDate = sealingDate;
    }

    public Spouse getSpouse() {
        return spouse;
    }

    public void setSpouse(Spouse spouse) {
        this.spouse = spouse;
    }

    public String getTemple() {
        return temple;
    }

    public void setTemple(String temple) {
        this.temple = temple;
    }

}



class Member {

    @SerializedName("ageGroup")
    @Expose
    private String ageGroup;
    @SerializedName("bic")
    @Expose
    private Boolean bic;
    @SerializedName("birthCountry")
    @Expose
    private String birthCountry;
    @SerializedName("birthDate")
    @Expose
    private String birthDate;
    @SerializedName("birthPlace")
    @Expose
    private String birthPlace;
    @SerializedName("cameFromAddressUnknown")
    @Expose
    private Boolean cameFromAddressUnknown;
    @SerializedName("classes")
    @Expose
    private List<String> classes = null;
    @SerializedName("displayName")
    @Expose
    private String displayName;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("familyName")
    @Expose
    private String familyName;
    @SerializedName("father")
    @Expose
    private Father father;
    @SerializedName("givenName")
    @Expose
    private String givenName;
    @SerializedName("head")
    @Expose
    private Boolean head;
    @SerializedName("householdUuid")
    @Expose
    private String householdUuid;
    @SerializedName("individualId")
    @Expose
    private Integer individualId;
    @SerializedName("maidenName")
    @Expose
    private String maidenName;
    @SerializedName("marriage")
    @Expose
    private Marriage marriage;
    @SerializedName("missionCountry")
    @Expose
    private String missionCountry;
    @SerializedName("missionLanguage")
    @Expose
    private String missionLanguage;
    @SerializedName("mother")
    @Expose
    private Mother mother;
    @SerializedName("mrn")
    @Expose
    private String mrn;
    @SerializedName("officialName")
    @Expose
    private String officialName;
    @SerializedName("ordinances")
    @Expose
    private List<Ordinance> ordinances = null;
    @SerializedName("permissions")
    @Expose
    private List<String> permissions = null;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("positions")
    @Expose
    private List<Position> positions = null;
    @SerializedName("preferredName")
    @Expose
    private String preferredName;
    @SerializedName("priesthood")
    @Expose
    private String priesthood;
    @SerializedName("priorUnit")
    @Expose
    private PriorUnit priorUnit;
    @SerializedName("priorUnitMoveOutDate")
    @Expose
    private String priorUnitMoveOutDate;
    @SerializedName("privacy")
    @Expose
    private Privacy privacy;
    @SerializedName("sex")
    @Expose
    private String sex;
    @SerializedName("sortName")
    @Expose
    private String sortName;
    @SerializedName("templeRecommendExpiration")
    @Expose
    private String templeRecommendExpiration;
    @SerializedName("templeRecommendStatus")
    @Expose
    private String templeRecommendStatus;
    @SerializedName("templeRecommendType")
    @Expose
    private String templeRecommendType;
    @SerializedName("unitMoveInDate")
    @Expose
    private String unitMoveInDate;
    @SerializedName("uuid")
    @Expose
    private String uuid;

    public String getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }

    public Boolean getBic() {
        return bic;
    }

    public void setBic(Boolean bic) {
        this.bic = bic;
    }

    public String getBirthCountry() {
        return birthCountry;
    }

    public void setBirthCountry(String birthCountry) {
        this.birthCountry = birthCountry;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public Boolean getCameFromAddressUnknown() {
        return cameFromAddressUnknown;
    }

    public void setCameFromAddressUnknown(Boolean cameFromAddressUnknown) {
        this.cameFromAddressUnknown = cameFromAddressUnknown;
    }

    public List<String> getClasses() {
        return classes;
    }

    public void setClasses(List<String> classes) {
        this.classes = classes;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public Father getFather() {
        return father;
    }

    public void setFather(Father father) {
        this.father = father;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public Boolean getHead() {
        return head;
    }

    public void setHead(Boolean head) {
        this.head = head;
    }

    public String getHouseholdUuid() {
        return householdUuid;
    }

    public void setHouseholdUuid(String householdUuid) {
        this.householdUuid = householdUuid;
    }

    public Integer getIndividualId() {
        return individualId;
    }

    public void setIndividualId(Integer individualId) {
        this.individualId = individualId;
    }

    public String getMaidenName() {
        return maidenName;
    }

    public void setMaidenName(String maidenName) {
        this.maidenName = maidenName;
    }

    public Marriage getMarriage() {
        return marriage;
    }

    public void setMarriage(Marriage marriage) {
        this.marriage = marriage;
    }

    public String getMissionCountry() {
        return missionCountry;
    }

    public void setMissionCountry(String missionCountry) {
        this.missionCountry = missionCountry;
    }

    public String getMissionLanguage() {
        return missionLanguage;
    }

    public void setMissionLanguage(String missionLanguage) {
        this.missionLanguage = missionLanguage;
    }

    public Mother getMother() {
        return mother;
    }

    public void setMother(Mother mother) {
        this.mother = mother;
    }

    public String getMrn() {
        return mrn;
    }

    public void setMrn(String mrn) {
        this.mrn = mrn;
    }

    public String getOfficialName() {
        return officialName;
    }

    public void setOfficialName(String officialName) {
        this.officialName = officialName;
    }

    public List<Ordinance> getOrdinances() {
        return ordinances;
    }

    public void setOrdinances(List<Ordinance> ordinances) {
        this.ordinances = ordinances;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

    public String getPreferredName() {
        return preferredName;
    }

    public void setPreferredName(String preferredName) {
        this.preferredName = preferredName;
    }

    public String getPriesthood() {
        return priesthood;
    }

    public void setPriesthood(String priesthood) {
        this.priesthood = priesthood;
    }

    public PriorUnit getPriorUnit() {
        return priorUnit;
    }

    public void setPriorUnit(PriorUnit priorUnit) {
        this.priorUnit = priorUnit;
    }

    public String getPriorUnitMoveOutDate() {
        return priorUnitMoveOutDate;
    }

    public void setPriorUnitMoveOutDate(String priorUnitMoveOutDate) {
        this.priorUnitMoveOutDate = priorUnitMoveOutDate;
    }

    public Privacy getPrivacy() {
        return privacy;
    }

    public void setPrivacy(Privacy privacy) {
        this.privacy = privacy;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public String getTempleRecommendExpiration() {
        return templeRecommendExpiration;
    }

    public void setTempleRecommendExpiration(String templeRecommendExpiration) {
        this.templeRecommendExpiration = templeRecommendExpiration;
    }

    public String getTempleRecommendStatus() {
        return templeRecommendStatus;
    }

    public void setTempleRecommendStatus(String templeRecommendStatus) {
        this.templeRecommendStatus = templeRecommendStatus;
    }

    public String getTempleRecommendType() {
        return templeRecommendType;
    }

    public void setTempleRecommendType(String templeRecommendType) {
        this.templeRecommendType = templeRecommendType;
    }

    public String getUnitMoveInDate() {
        return unitMoveInDate;
    }

    public void setUnitMoveInDate(String unitMoveInDate) {
        this.unitMoveInDate = unitMoveInDate;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

}



class Mother {

    @SerializedName("birthDate")
    @Expose
    private String birthDate;
    @SerializedName("displayName")
    @Expose
    private String displayName;
    @SerializedName("uuid")
    @Expose
    private String uuid;

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

}





class Ordinance {

    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("officiator")
    @Expose
    private String officiator;
    @SerializedName("temple")
    @Expose
    private String temple;
    @SerializedName("type")
    @Expose
    private String type;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOfficiator() {
        return officiator;
    }

    public void setOfficiator(String officiator) {
        this.officiator = officiator;
    }

    public String getTemple() {
        return temple;
    }

    public void setTemple(String temple) {
        this.temple = temple;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}





class Position {

    @SerializedName("activeDate")
    @Expose
    private String activeDate;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("setApart")
    @Expose
    private Boolean setApart;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("unitName")
    @Expose
    private String unitName;
    @SerializedName("unitNumber")
    @Expose
    private Integer unitNumber;
    @SerializedName("uuid")
    @Expose
    private String uuid;

    public String getActiveDate() {
        return activeDate;
    }

    public void setActiveDate(String activeDate) {
        this.activeDate = activeDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getSetApart() {
        return setApart;
    }

    public void setSetApart(Boolean setApart) {
        this.setApart = setApart;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public Integer getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(Integer unitNumber) {
        this.unitNumber = unitNumber;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

}






class PriorUnit {

    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("childUnits")
    @Expose
    private List<Object> childUnits = null;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("unitNumber")
    @Expose
    private Integer unitNumber;
    @SerializedName("unitType")
    @Expose
    private String unitType;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Object> getChildUnits() {
        return childUnits;
    }

    public void setChildUnits(List<Object> childUnits) {
        this.childUnits = childUnits;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(Integer unitNumber) {
        this.unitNumber = unitNumber;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

}



class Privacy {

    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("coordinates")
    @Expose
    private String coordinates;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("master")
    @Expose
    private String master;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("photo")
    @Expose
    private String photo;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

}





class Privacy_ {

    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("coordinates")
    @Expose
    private String coordinates;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("master")
    @Expose
    private String master;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("photo")
    @Expose
    private String photo;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

}





class Spouse {

    @SerializedName("birthDate")
    @Expose
    private String birthDate;
    @SerializedName("displayName")
    @Expose
    private String displayName;
    @SerializedName("uuid")
    @Expose
    private String uuid;

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

}

