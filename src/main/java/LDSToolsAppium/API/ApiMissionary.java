package LDSToolsAppium.API;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApiMissionary {

    @SerializedName("assigned")
    @Expose
    private List<Assigned> assigned = null;
    @SerializedName("serving")
    @Expose
    private List<Serving> serving = null;

    public List<Assigned> getAssigned() {
        return assigned;
    }

    public void setAssigned(List<Assigned> assigned) {
        this.assigned = assigned;
    }

    public List<Serving> getServing() {
        return serving;
    }

    public void setServing(List<Serving> serving) {
        this.serving = serving;
    }

}


class Assigned {

    @SerializedName("areaId")
    @Expose
    private Integer areaId;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("mission")
    @Expose
    private Mission mission;
    @SerializedName("missionaries")
    @Expose
    private List<Missionary> missionaries = null;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("unitNumbers")
    @Expose
    private List<Integer> unitNumbers = null;

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Mission getMission() {
        return mission;
    }

    public void setMission(Mission mission) {
        this.mission = mission;
    }

    public List<Missionary> getMissionaries() {
        return missionaries;
    }

    public void setMissionaries(List<Missionary> missionaries) {
        this.missionaries = missionaries;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Integer> getUnitNumbers() {
        return unitNumbers;
    }

    public void setUnitNumbers(List<Integer> unitNumbers) {
        this.unitNumbers = unitNumbers;
    }

}


class Mission {

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


class Mission_ {

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


class Mission__ {

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


class Missionary {

    @SerializedName("displayName")
    @Expose
    private String displayName;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("mission")
    @Expose
    private Mission_ mission;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("preferredName")
    @Expose
    private String preferredName;
    @SerializedName("sex")
    @Expose
    private String sex;
    @SerializedName("sortName")
    @Expose
    private String sortName;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("unitNumber")
    @Expose
    private Integer unitNumber;
    @SerializedName("uuid")
    @Expose
    private String uuid;

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

    public Mission_ getMission() {
        return mission;
    }

    public void setMission(Mission_ mission) {
        this.mission = mission;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPreferredName() {
        return preferredName;
    }

    public void setPreferredName(String preferredName) {
        this.preferredName = preferredName;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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


class Serving {

    @SerializedName("displayName")
    @Expose
    private String displayName;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("mission")
    @Expose
    private Mission__ mission;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("preferredName")
    @Expose
    private String preferredName;
    @SerializedName("sex")
    @Expose
    private String sex;
    @SerializedName("sortName")
    @Expose
    private String sortName;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("unitNumber")
    @Expose
    private Integer unitNumber;
    @SerializedName("uuid")
    @Expose
    private String uuid;

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

    public Mission__ getMission() {
        return mission;
    }

    public void setMission(Mission__ mission) {
        this.mission = mission;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPreferredName() {
        return preferredName;
    }

    public void setPreferredName(String preferredName) {
        this.preferredName = preferredName;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
