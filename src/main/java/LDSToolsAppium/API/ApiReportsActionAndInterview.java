package LDSToolsAppium.API;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class ApiReportActionAndInterview {

    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("members")
    @Expose
    private List<ActionAndInterviewMember> members = null;
    @SerializedName("month")
    @Expose
    private String month;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("unitNumber")
    @Expose
    private Integer unitNumber;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ActionAndInterviewMember> getMembers() {
        return members;
    }

    public void setMembers(List<ActionAndInterviewMember> members) {
        this.members = members;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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


class ActionAndInterviewMember {

    @SerializedName("action")
    @Expose
    private String action;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("uuid")
    @Expose
    private String uuid;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

}
