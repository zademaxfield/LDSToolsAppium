package LDSToolsAppium.API; ;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class ApiLists {

    @SerializedName("members")
    @Expose
    private List<String> members = null;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("removed")
    @Expose
    private Boolean removed;
    @SerializedName("sort")
    @Expose
    private Integer sort;
    @SerializedName("uuid")
    @Expose
    private String uuid;

    public List<String> getMembers() {
        return members;
    }

    public void setMembers(List<String> members) {
        this.members = members;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getRemoved() {
        return removed;
    }

    public void setRemoved(Boolean removed) {
        this.removed = removed;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

}
