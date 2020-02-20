package LDSToolsAppium.API;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApiOrganization {

    @SerializedName("uuid")
    @Expose
    private String uuid;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("unitNumber")
    @Expose
    private Integer unitNumber;
    @SerializedName("orgTypes")
    @Expose
    private List<String> orgTypes = null;
    @SerializedName("positions")
    @Expose
    private List<String> positions = null;
    @SerializedName("childOrgs")
    @Expose
    private List<ChildOrg> childOrgs = null;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(Integer unitNumber) {
        this.unitNumber = unitNumber;
    }

    public List<String> getOrgTypes() {
        return orgTypes;
    }

    public void setOrgTypes(List<String> orgTypes) {
        this.orgTypes = orgTypes;
    }

    public List<String> getPositions() {
        return positions;
    }

    public void setPositions(List<String> positions) {
        this.positions = positions;
    }

    public List<ChildOrg> getChildOrgs() {
        return childOrgs;
    }

    public void setChildOrgs(List<ChildOrg> childOrgs) {
        this.childOrgs = childOrgs;
    }

}

class ChildOrg {

    @SerializedName("uuid")
    @Expose
    private String uuid;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("unitNumber")
    @Expose
    private Integer unitNumber;
    @SerializedName("orgTypes")
    @Expose
    private List<String> orgTypes = null;
    @SerializedName("positions")
    @Expose
    private List<String> positions = null;
    @SerializedName("childOrgs")
    @Expose
    private List<ChildOrg_> childOrgs = null;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(Integer unitNumber) {
        this.unitNumber = unitNumber;
    }

    public List<String> getOrgTypes() {
        return orgTypes;
    }

    public void setOrgTypes(List<String> orgTypes) {
        this.orgTypes = orgTypes;
    }

    public List<String> getPositions() {
        return positions;
    }

    public void setPositions(List<String> positions) {
        this.positions = positions;
    }

    public List<ChildOrg_> getChildOrgs() {
        return childOrgs;
    }

    public void setChildOrgs(List<ChildOrg_> childOrgs) {
        this.childOrgs = childOrgs;
    }

}

class ChildOrg_ {

    @SerializedName("uuid")
    @Expose
    private String uuid;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("unitNumber")
    @Expose
    private Integer unitNumber;
    @SerializedName("orgTypes")
    @Expose
    private List<String> orgTypes = null;
    @SerializedName("positions")
    @Expose
    private List<String> positions = null;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(Integer unitNumber) {
        this.unitNumber = unitNumber;
    }

    public List<String> getOrgTypes() {
        return orgTypes;
    }

    public void setOrgTypes(List<String> orgTypes) {
        this.orgTypes = orgTypes;
    }

    public List<String> getPositions() {
        return positions;
    }

    public void setPositions(List<String> positions) {
        this.positions = positions;
    }

}

