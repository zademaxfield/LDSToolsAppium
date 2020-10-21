package LDSToolsAppium.API;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApiCovenantPath {

    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("baptismGoalDate")
    @Expose
    private String baptismGoalDate;
    @SerializedName("commitments")
    @Expose
    private List<Commitment> commitments = null;
    @SerializedName("confirmationDate")
    @Expose
    private String confirmationDate;
    @SerializedName("coordinates")
    @Expose
    private CoordinatesCP coordinates;
    @SerializedName("displayName")
    @Expose
    private String displayName;
    @SerializedName("emails")
    @Expose
    private List<Email> emails = null;
    @SerializedName("endowmentEligibilityDate")
    @Expose
    private String endowmentEligibilityDate;
    @SerializedName("firstTaught")
    @Expose
    private String firstTaught;
    @SerializedName("friends")
    @Expose
    private List<Friend> friends = null;
    @SerializedName("friendsDisplay")
    @Expose
    private String friendsDisplay;
    @SerializedName("helpNeeded")
    @Expose
    private List<HelpNeeded> helpNeeded = null;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("memberUuid")
    @Expose
    private String memberUuid;
    @SerializedName("nextAppointment")
    @Expose
    private String nextAppointment;
    @SerializedName("optedOut")
    @Expose
    private Boolean optedOut;
    @SerializedName("otherCommitments")
    @Expose
    private List<OtherCommitment> otherCommitments = null;
    @SerializedName("permissions")
    @Expose
    private List<String> permissions = null;
    @SerializedName("phones")
    @Expose
    private List<Phone_> phones = null;
    @SerializedName("priesthoodEligibility")
    @Expose
    private String priesthoodEligibility;
    @SerializedName("progressAlerts")
    @Expose
    private ProgressAlerts progressAlerts;
    @SerializedName("sacramentAttendance")
    @Expose
    private List<SacramentAttendance> sacramentAttendance = null;
    @SerializedName("sacramentMeetingsMissed")
    @Expose
    private Integer sacramentMeetingsMissed;
    @SerializedName("sealedToParents")
    @Expose
    private Boolean sealedToParents;
    @SerializedName("sealedToSpouse")
    @Expose
    private Boolean sealedToSpouse;
    @SerializedName("selfRelianceCourses")
    @Expose
    private List<SelfRelianceCourse> selfRelianceCourses = null;
    @SerializedName("socialMedia")
    @Expose
    private List<SocialMedium> socialMedia = null;
    @SerializedName("sortName")
    @Expose
    private String sortName;
    @SerializedName("sortOrder")
    @Expose
    private Integer sortOrder;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("teachingRecords")
    @Expose
    private List<TeachingRecord> teachingRecords = null;
    @SerializedName("unitNumber")
    @Expose
    private Integer unitNumber;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBaptismGoalDate() {
        return baptismGoalDate;
    }

    public void setBaptismGoalDate(String baptismGoalDate) {
        this.baptismGoalDate = baptismGoalDate;
    }

    public List<Commitment> getCommitments() {
        return commitments;
    }

    public void setCommitments(List<Commitment> commitments) {
        this.commitments = commitments;
    }

    public String getConfirmationDate() {
        return confirmationDate;
    }

    public void setConfirmationDate(String confirmationDate) {
        this.confirmationDate = confirmationDate;
    }

    public CoordinatesCP getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(CoordinatesCP coordinates) {
        this.coordinates = coordinates;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    public String getEndowmentEligibilityDate() {
        return endowmentEligibilityDate;
    }

    public void setEndowmentEligibilityDate(String endowmentEligibilityDate) {
        this.endowmentEligibilityDate = endowmentEligibilityDate;
    }

    public String getFirstTaught() {
        return firstTaught;
    }

    public void setFirstTaught(String firstTaught) {
        this.firstTaught = firstTaught;
    }

    public List<Friend> getFriends() {
        return friends;
    }

    public void setFriends(List<Friend> friends) {
        this.friends = friends;
    }

    public String getFriendsDisplay() {
        return friendsDisplay;
    }

    public void setFriendsDisplay(String friendsDisplay) {
        this.friendsDisplay = friendsDisplay;
    }

    public List<HelpNeeded> getHelpNeeded() {
        return helpNeeded;
    }

    public void setHelpNeeded(List<HelpNeeded> helpNeeded) {
        this.helpNeeded = helpNeeded;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMemberUuid() {
        return memberUuid;
    }

    public void setMemberUuid(String memberUuid) {
        this.memberUuid = memberUuid;
    }

    public String getNextAppointment() {
        return nextAppointment;
    }

    public void setNextAppointment(String nextAppointment) {
        this.nextAppointment = nextAppointment;
    }

    public Boolean getOptedOut() {
        return optedOut;
    }

    public void setOptedOut(Boolean optedOut) {
        this.optedOut = optedOut;
    }

    public List<OtherCommitment> getOtherCommitments() {
        return otherCommitments;
    }

    public void setOtherCommitments(List<OtherCommitment> otherCommitments) {
        this.otherCommitments = otherCommitments;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

    public List<Phone_> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone_> phones) {
        this.phones = phones;
    }

    public String getPriesthoodEligibility() {
        return priesthoodEligibility;
    }

    public void setPriesthoodEligibility(String priesthoodEligibility) {
        this.priesthoodEligibility = priesthoodEligibility;
    }

    public ProgressAlerts getProgressAlerts() {
        return progressAlerts;
    }

    public void setProgressAlerts(ProgressAlerts progressAlerts) {
        this.progressAlerts = progressAlerts;
    }

    public List<SacramentAttendance> getSacramentAttendance() {
        return sacramentAttendance;
    }

    public void setSacramentAttendance(List<SacramentAttendance> sacramentAttendance) {
        this.sacramentAttendance = sacramentAttendance;
    }

    public Integer getSacramentMeetingsMissed() {
        return sacramentMeetingsMissed;
    }

    public void setSacramentMeetingsMissed(Integer sacramentMeetingsMissed) {
        this.sacramentMeetingsMissed = sacramentMeetingsMissed;
    }

    public Boolean getSealedToParents() {
        return sealedToParents;
    }

    public void setSealedToParents(Boolean sealedToParents) {
        this.sealedToParents = sealedToParents;
    }

    public Boolean getSealedToSpouse() {
        return sealedToSpouse;
    }

    public void setSealedToSpouse(Boolean sealedToSpouse) {
        this.sealedToSpouse = sealedToSpouse;
    }

    public List<SelfRelianceCourse> getSelfRelianceCourses() {
        return selfRelianceCourses;
    }

    public void setSelfRelianceCourses(List<SelfRelianceCourse> selfRelianceCourses) {
        this.selfRelianceCourses = selfRelianceCourses;
    }

    public List<SocialMedium> getSocialMedia() {
        return socialMedia;
    }

    public void setSocialMedia(List<SocialMedium> socialMedia) {
        this.socialMedia = socialMedia;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<TeachingRecord> getTeachingRecords() {
        return teachingRecords;
    }

    public void setTeachingRecords(List<TeachingRecord> teachingRecords) {
        this.teachingRecords = teachingRecords;
    }

    public Integer getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(Integer unitNumber) {
        this.unitNumber = unitNumber;
    }

}

class Commitment {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("invitationDate")
    @Expose
    private String invitationDate;
    @SerializedName("isKeeping")
    @Expose
    private Boolean isKeeping;
    @SerializedName("sortOrder")
    @Expose
    private Integer sortOrder;
    @SerializedName("title")
    @Expose
    private String title;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInvitationDate() {
        return invitationDate;
    }

    public void setInvitationDate(String invitationDate) {
        this.invitationDate = invitationDate;
    }

    public Boolean getIsKeeping() {
        return isKeeping;
    }

    public void setIsKeeping(Boolean isKeeping) {
        this.isKeeping = isKeeping;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}


class CoordinatesCP {

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

class Email {

    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("type")
    @Expose
    private String type;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}

class Email_ {

    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("type")
    @Expose
    private String type;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}



class Friend {

    @SerializedName("displayName")
    @Expose
    private String displayName;
    @SerializedName("emails")
    @Expose
    private List<Email_> emails = null;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("memberUuid")
    @Expose
    private String memberUuid;
    @SerializedName("phones")
    @Expose
    private List<Phone> phones = null;
    @SerializedName("removed")
    @Expose
    private Boolean removed;
    @SerializedName("sortName")
    @Expose
    private String sortName;

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public List<Email_> getEmails() {
        return emails;
    }

    public void setEmails(List<Email_> emails) {
        this.emails = emails;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMemberUuid() {
        return memberUuid;
    }

    public void setMemberUuid(String memberUuid) {
        this.memberUuid = memberUuid;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
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

}



class HelpNeeded {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("removed")
    @Expose
    private Boolean removed;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("type")
    @Expose
    private String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getRemoved() {
        return removed;
    }

    public void setRemoved(Boolean removed) {
        this.removed = removed;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}




class OtherCommitment {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("interested")
    @Expose
    private Boolean interested;
    @SerializedName("sortOrder")
    @Expose
    private Integer sortOrder;
    @SerializedName("title")
    @Expose
    private String title;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getInterested() {
        return interested;
    }

    public void setInterested(Boolean interested) {
        this.interested = interested;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}



class Phone {

    @SerializedName("number")
    @Expose
    private String number;
    @SerializedName("type")
    @Expose
    private String type;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}



class Phone_ {

    @SerializedName("number")
    @Expose
    private String number;
    @SerializedName("type")
    @Expose
    private String type;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}




class Principle {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("memberPresent")
    @Expose
    private Boolean memberPresent;
    @SerializedName("taught")
    @Expose
    private Boolean taught;
    @SerializedName("title")
    @Expose
    private String title;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getMemberPresent() {
        return memberPresent;
    }

    public void setMemberPresent(Boolean memberPresent) {
        this.memberPresent = memberPresent;
    }

    public Boolean getTaught() {
        return taught;
    }

    public void setTaught(Boolean taught) {
        this.taught = taught;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}




class ProgressAlerts {

    @SerializedName("aaronicPriesthoodDeadline")
    @Expose
    private String aaronicPriesthoodDeadline;
    @SerializedName("addAFriendDeadline")
    @Expose
    private String addAFriendDeadline;
    @SerializedName("missedTooMuchSacrament")
    @Expose
    private String missedTooMuchSacrament;

    public String getAaronicPriesthoodDeadline() {
        return aaronicPriesthoodDeadline;
    }

    public void setAaronicPriesthoodDeadline(String aaronicPriesthoodDeadline) {
        this.aaronicPriesthoodDeadline = aaronicPriesthoodDeadline;
    }

    public String getAddAFriendDeadline() {
        return addAFriendDeadline;
    }

    public void setAddAFriendDeadline(String addAFriendDeadline) {
        this.addAFriendDeadline = addAFriendDeadline;
    }

    public String getMissedTooMuchSacrament() {
        return missedTooMuchSacrament;
    }

    public void setMissedTooMuchSacrament(String missedTooMuchSacrament) {
        this.missedTooMuchSacrament = missedTooMuchSacrament;
    }

}




class SacramentAttendance {

    @SerializedName("attended")
    @Expose
    private Boolean attended;
    @SerializedName("date")
    @Expose
    private String date;

    public Boolean getAttended() {
        return attended;
    }

    public void setAttended(Boolean attended) {
        this.attended = attended;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}




class SelfRelianceCourse {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("interested")
    @Expose
    private Boolean interested;
    @SerializedName("sortOrder")
    @Expose
    private Integer sortOrder;
    @SerializedName("title")
    @Expose
    private String title;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getInterested() {
        return interested;
    }

    public void setInterested(Boolean interested) {
        this.interested = interested;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}




class SocialMedium {

    @SerializedName("handle")
    @Expose
    private String handle;
    @SerializedName("platform")
    @Expose
    private String platform;

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

}





class TeachingRecord {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("principles")
    @Expose
    private List<Principle> principles = null;
    @SerializedName("title")
    @Expose
    private String title;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Principle> getPrinciples() {
        return principles;
    }

    public void setPrinciples(List<Principle> principles) {
        this.principles = principles;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}

