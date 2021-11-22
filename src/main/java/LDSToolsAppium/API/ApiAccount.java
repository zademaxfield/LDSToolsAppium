package LDSToolsAppium.API;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ApiAccount {

    @SerializedName("homeUnits")
    @Expose
    private List<Integer> homeUnits = null;
    @SerializedName("ldsAccountId")
    @Expose
    private Integer ldsAccountId;
    @SerializedName("member")
    @Expose
    private Boolean member;
    @SerializedName("positions")
    @Expose
    private List<PositionAccount> positions = null;
    @SerializedName("username")
    @Expose
    private String username;

    public List<Integer> getHomeUnits() {
        return homeUnits;
    }

    public void setHomeUnits(List<Integer> homeUnits) {
        this.homeUnits = homeUnits;
    }

    public Integer getLdsAccountId() {
        return ldsAccountId;
    }

    public void setLdsAccountId(Integer ldsAccountId) {
        this.ldsAccountId = ldsAccountId;
    }

    public Boolean getMember() {
        return member;
    }

    public void setMember(Boolean member) {
        this.member = member;
    }

    public List<PositionAccount> getPositions() {
        return positions;
    }

    public void setPositions(List<PositionAccount> positions) {
        this.positions = positions;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}

class PositionAccount {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("unitNumber")
    @Expose
    private Integer unitNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

}