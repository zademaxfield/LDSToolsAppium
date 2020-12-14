package LDSToolsAppium.API;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApiClassQuorumAttendance {

    @SerializedName("orgUuids")
    @Expose
    private List<String> orgUuids = null;
    @SerializedName("unitNumber")
    @Expose
    private Integer unitNumber;
    @SerializedName("weeks")
    @Expose
    private List<Week> weeks = null;

    public List<String> getOrgUuids() {
        return orgUuids;
    }

    public void setOrgUuids(List<String> orgUuids) {
        this.orgUuids = orgUuids;
    }

    public Integer getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(Integer unitNumber) {
        this.unitNumber = unitNumber;
    }

    public List<Week> getWeeks() {
        return weeks;
    }

    public void setWeeks(List<Week> weeks) {
        this.weeks = weeks;
    }

}


class Week {

    @SerializedName("attended")
    @Expose
    private List<String> attended = null;
    @SerializedName("editable")
    @Expose
    private Boolean editable;
    @SerializedName("unattended")
    @Expose
    private List<String> unattended = null;
    @SerializedName("week")
    @Expose
    private String week;

    public List<String> getAttended() {
        return attended;
    }

    public void setAttended(List<String> attended) {
        this.attended = attended;
    }

    public Boolean getEditable() {
        return editable;
    }

    public void setEditable(Boolean editable) {
        this.editable = editable;
    }

    public List<String> getUnattended() {
        return unattended;
    }

    public void setUnattended(List<String> unattended) {
        this.unattended = unattended;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

}

