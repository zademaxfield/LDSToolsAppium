package LDSToolsAppium.API; ;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiFinance {

    @SerializedName("expenses")
    @Expose
    private List<Expense> expenses = null;
    @SerializedName("month")
    @Expose
    private String month;
    @SerializedName("removed")
    @Expose
    private Boolean removed;
    @SerializedName("unitNumber")
    @Expose
    private Integer unitNumber;

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Boolean getRemoved() {
        return removed;
    }

    public void setRemoved(Boolean removed) {
        this.removed = removed;
    }

    public Integer getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(Integer unitNumber) {
        this.unitNumber = unitNumber;
    }

}

class Address {

    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("countryId")
    @Expose
    private Integer countryId;
    @SerializedName("county")
    @Expose
    private String county;
    @SerializedName("formatted")
    @Expose
    private String formatted;
    @SerializedName("postalCode")
    @Expose
    private String postalCode;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("stateId")
    @Expose
    private Integer stateId;
    @SerializedName("street1")
    @Expose
    private String street1;
    @SerializedName("street2")
    @Expose
    private String street2;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getFormatted() {
        return formatted;
    }

    public void setFormatted(String formatted) {
        this.formatted = formatted;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

}

class Address__1 {

    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("countryId")
    @Expose
    private Integer countryId;
    @SerializedName("county")
    @Expose
    private String county;
    @SerializedName("formatted")
    @Expose
    private String formatted;
    @SerializedName("postalCode")
    @Expose
    private String postalCode;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("stateId")
    @Expose
    private Integer stateId;
    @SerializedName("street1")
    @Expose
    private String street1;
    @SerializedName("street2")
    @Expose
    private String street2;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getFormatted() {
        return formatted;
    }

    public void setFormatted(String formatted) {
        this.formatted = formatted;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

}




class Charge {

    @SerializedName("amount")
    @Expose
    private Integer amount;
    @SerializedName("categoryId")
    @Expose
    private Integer categoryId;
    @SerializedName("recipient")
    @Expose
    private Recipient recipient;
    @SerializedName("subcategory")
    @Expose
    private Subcategory subcategory;
    @SerializedName("subcategoryId")
    @Expose
    private Integer subcategoryId;

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    public Subcategory getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }

    public Integer getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(Integer subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

}

class EmailFinance {

    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("privacy")
    @Expose
    private String privacy;
    @SerializedName("type")
    @Expose
    private String type;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPrivacy() {
        return privacy;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}

class Email__1 {

    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("privacy")
    @Expose
    private String privacy;
    @SerializedName("type")
    @Expose
    private String type;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPrivacy() {
        return privacy;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}




class Expense {

    @SerializedName("accountId")
    @Expose
    private Integer accountId;
    @SerializedName("approvedRejectedBy")
    @Expose
    private String approvedRejectedBy;
    @SerializedName("charges")
    @Expose
    private List<Charge> charges = null;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("payee")
    @Expose
    private Payee payee;
    @SerializedName("paymentMethodId")
    @Expose
    private Integer paymentMethodId;
    @SerializedName("purpose")
    @Expose
    private String purpose;
    @SerializedName("reasonForRejection")
    @Expose
    private String reasonForRejection;
    @SerializedName("receiptCount")
    @Expose
    private Integer receiptCount;
    @SerializedName("receiptHash")
    @Expose
    private String receiptHash;
    @SerializedName("referenceNumber")
    @Expose
    private String referenceNumber;
    @SerializedName("removeReceipts")
    @Expose
    private List<String> removeReceipts = null;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("submittedBy")
    @Expose
    private String submittedBy;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("unitNumber")
    @Expose
    private Integer unitNumber;

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getApprovedRejectedBy() {
        return approvedRejectedBy;
    }

    public void setApprovedRejectedBy(String approvedRejectedBy) {
        this.approvedRejectedBy = approvedRejectedBy;
    }

    public List<Charge> getCharges() {
        return charges;
    }

    public void setCharges(List<Charge> charges) {
        this.charges = charges;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Payee getPayee() {
        return payee;
    }

    public void setPayee(Payee payee) {
        this.payee = payee;
    }

    public Integer getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(Integer paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getReasonForRejection() {
        return reasonForRejection;
    }

    public void setReasonForRejection(String reasonForRejection) {
        this.reasonForRejection = reasonForRejection;
    }

    public Integer getReceiptCount() {
        return receiptCount;
    }

    public void setReceiptCount(Integer receiptCount) {
        this.receiptCount = receiptCount;
    }

    public String getReceiptHash() {
        return receiptHash;
    }

    public void setReceiptHash(String receiptHash) {
        this.receiptHash = receiptHash;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public List<String> getRemoveReceipts() {
        return removeReceipts;
    }

    public void setRemoveReceipts(List<String> removeReceipts) {
        this.removeReceipts = removeReceipts;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSubmittedBy() {
        return submittedBy;
    }

    public void setSubmittedBy(String submittedBy) {
        this.submittedBy = submittedBy;
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

class Payee {

    @SerializedName("address")
    @Expose
    private Address__1 address;
    @SerializedName("emails")
    @Expose
    private List<Email__1> emails = null;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("memberMrn")
    @Expose
    private String memberMrn;
    @SerializedName("memberUuid")
    @Expose
    private String memberUuid;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("paymentMethodIds")
    @Expose
    private List<Integer> paymentMethodIds = null;
    @SerializedName("phones")
    @Expose
    private List<Phone__1> phones = null;
    @SerializedName("referenceId")
    @Expose
    private String referenceId;
    @SerializedName("unitNumber")
    @Expose
    private Integer unitNumber;

    public Address__1 getAddress() {
        return address;
    }

    public void setAddress(Address__1 address) {
        this.address = address;
    }

    public List<Email__1> getEmails() {
        return emails;
    }

    public void setEmails(List<Email__1> emails) {
        this.emails = emails;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMemberMrn() {
        return memberMrn;
    }

    public void setMemberMrn(String memberMrn) {
        this.memberMrn = memberMrn;
    }

    public String getMemberUuid() {
        return memberUuid;
    }

    public void setMemberUuid(String memberUuid) {
        this.memberUuid = memberUuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getPaymentMethodIds() {
        return paymentMethodIds;
    }

    public void setPaymentMethodIds(List<Integer> paymentMethodIds) {
        this.paymentMethodIds = paymentMethodIds;
    }

    public List<Phone__1> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone__1> phones) {
        this.phones = phones;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public Integer getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(Integer unitNumber) {
        this.unitNumber = unitNumber;
    }

}

class PhoneFinance {

    @SerializedName("number")
    @Expose
    private String number;
    @SerializedName("privacy")
    @Expose
    private String privacy;
    @SerializedName("type")
    @Expose
    private String type;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPrivacy() {
        return privacy;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}




class Phone__1 {

    @SerializedName("number")
    @Expose
    private String number;
    @SerializedName("privacy")
    @Expose
    private String privacy;
    @SerializedName("type")
    @Expose
    private String type;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPrivacy() {
        return privacy;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}





class Recipient {

    @SerializedName("address")
    @Expose
    private Address address;
    @SerializedName("emails")
    @Expose
    private List<Email> emails = null;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("memberMrn")
    @Expose
    private String memberMrn;
    @SerializedName("memberUuid")
    @Expose
    private String memberUuid;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("paymentMethodIds")
    @Expose
    private List<Integer> paymentMethodIds = null;
    @SerializedName("phones")
    @Expose
    private List<Phone> phones = null;
    @SerializedName("referenceId")
    @Expose
    private String referenceId;
    @SerializedName("unitNumber")
    @Expose
    private Integer unitNumber;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMemberMrn() {
        return memberMrn;
    }

    public void setMemberMrn(String memberMrn) {
        this.memberMrn = memberMrn;
    }

    public String getMemberUuid() {
        return memberUuid;
    }

    public void setMemberUuid(String memberUuid) {
        this.memberUuid = memberUuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getPaymentMethodIds() {
        return paymentMethodIds;
    }

    public void setPaymentMethodIds(List<Integer> paymentMethodIds) {
        this.paymentMethodIds = paymentMethodIds;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public Integer getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(Integer unitNumber) {
        this.unitNumber = unitNumber;
    }

}





class Subcategory {

    @SerializedName("accountId")
    @Expose
    private Integer accountId;
    @SerializedName("active")
    @Expose
    private Boolean active;
    @SerializedName("categoryId")
    @Expose
    private Integer categoryId;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("permissions")
    @Expose
    private List<String> permissions = null;
    @SerializedName("referenceId")
    @Expose
    private String referenceId;

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

}