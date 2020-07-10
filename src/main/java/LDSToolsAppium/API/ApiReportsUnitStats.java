package LDSToolsAppium.API;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class ApiReportUnitStat {

    @SerializedName("adultFemaleRecentConverts")
    @Expose
    private Integer adultFemaleRecentConverts;
    @SerializedName("adultFemaleRecentConvertsUuids")
    @Expose
    private List<String> adultFemaleRecentConvertsUuids = null;
    @SerializedName("adultMaleRecentConverts")
    @Expose
    private Integer adultMaleRecentConverts;
    @SerializedName("adultMaleRecentConvertsUuids")
    @Expose
    private List<String> adultMaleRecentConvertsUuids = null;
    @SerializedName("adults")
    @Expose
    private Integer adults;
    @SerializedName("adultsUuids")
    @Expose
    private List<String> adultsUuids = null;
    @SerializedName("baptizedNotConfirmed")
    @Expose
    private Integer baptizedNotConfirmed;
    @SerializedName("baptizedNotConfirmedUuids")
    @Expose
    private List<String> baptizedNotConfirmedUuids = null;
    @SerializedName("children")
    @Expose
    private Integer children;
    @SerializedName("childrenAge8to11RecentConverts")
    @Expose
    private Integer childrenAge8to11RecentConverts;
    @SerializedName("childrenAge8to11RecentConvertsUuids")
    @Expose
    private List<String> childrenAge8to11RecentConvertsUuids = null;
    @SerializedName("childrenUuids")
    @Expose
    private List<String> childrenUuids = null;
    @SerializedName("deacons")
    @Expose
    private Integer deacons;
    @SerializedName("deaconsUuids")
    @Expose
    private List<String> deaconsUuids = null;
    @SerializedName("elders")
    @Expose
    private Integer elders;
    @SerializedName("eldersUuids")
    @Expose
    private List<String> eldersUuids = null;
    @SerializedName("endowedAdults")
    @Expose
    private Integer endowedAdults;
    @SerializedName("endowedAdultsUuids")
    @Expose
    private List<String> endowedAdultsUuids = null;
    @SerializedName("endowedWithRecommend")
    @Expose
    private Integer endowedWithRecommend;
    @SerializedName("endowedWithRecommendUuids")
    @Expose
    private List<String> endowedWithRecommendUuids = null;
    @SerializedName("endowedWithoutRecommend")
    @Expose
    private Integer endowedWithoutRecommend;
    @SerializedName("endowedWithoutRecommendUuids")
    @Expose
    private List<String> endowedWithoutRecommendUuids = null;
    @SerializedName("highPriests")
    @Expose
    private Integer highPriests;
    @SerializedName("highPriestsUuids")
    @Expose
    private List<String> highPriestsUuids = null;
    @SerializedName("households")
    @Expose
    private Integer households;
    @SerializedName("householdsUuids")
    @Expose
    private List<String> householdsUuids = null;
    @SerializedName("householdsWithChildren")
    @Expose
    private Integer householdsWithChildren;
    @SerializedName("householdsWithChildrenUuids")
    @Expose
    private List<String> householdsWithChildrenUuids = null;
    @SerializedName("householdsWithSingleParentAndYouthOrChildren")
    @Expose
    private Integer householdsWithSingleParentAndYouthOrChildren;
    @SerializedName("householdsWithSingleParentAndYouthOrChildrenUuids")
    @Expose
    private List<String> householdsWithSingleParentAndYouthOrChildrenUuids = null;
    @SerializedName("householdsWithYouth")
    @Expose
    private Integer householdsWithYouth;
    @SerializedName("householdsWithYouthUuids")
    @Expose
    private List<String> householdsWithYouthUuids = null;
    @SerializedName("householdsWithoutMelchizedekPriesthoodHolder")
    @Expose
    private Integer householdsWithoutMelchizedekPriesthoodHolder;
    @SerializedName("householdsWithoutMelchizedekPriesthoodHolderUuids")
    @Expose
    private List<String> householdsWithoutMelchizedekPriesthoodHolderUuids = null;
    @SerializedName("individualsNotIncluded")
    @Expose
    private Integer individualsNotIncluded;
    @SerializedName("individualsNotIncludedUuids")
    @Expose
    private List<String> individualsNotIncludedUuids = null;
    @SerializedName("infants")
    @Expose
    private Integer infants;
    @SerializedName("infantsUuids")
    @Expose
    private List<String> infantsUuids = null;
    @SerializedName("invalidBirthdate")
    @Expose
    private Integer invalidBirthdate;
    @SerializedName("invalidBirthdateUuids")
    @Expose
    private List<String> invalidBirthdateUuids = null;
    @SerializedName("marriedAdults")
    @Expose
    private Integer marriedAdults;
    @SerializedName("marriedAdultsUuids")
    @Expose
    private List<String> marriedAdultsUuids = null;
    @SerializedName("membersOfRecordAge9OrOlder")
    @Expose
    private Integer membersOfRecordAge9OrOlder;
    @SerializedName("membersOfRecordAge9OrOlderUuids")
    @Expose
    private List<String> membersOfRecordAge9OrOlderUuids = null;
    @SerializedName("men")
    @Expose
    private Integer men;
    @SerializedName("menUuids")
    @Expose
    private List<String> menUuids = null;
    @SerializedName("ordainedRecentConverts")
    @Expose
    private Integer ordainedRecentConverts;
    @SerializedName("ordainedRecentConvertsUuids")
    @Expose
    private List<String> ordainedRecentConvertsUuids = null;
    @SerializedName("priests")
    @Expose
    private Integer priests;
    @SerializedName("priestsUuids")
    @Expose
    private List<String> priestsUuids = null;
    @SerializedName("prospectiveElders")
    @Expose
    private Integer prospectiveElders;
    @SerializedName("prospectiveEldersUuids")
    @Expose
    private List<String> prospectiveEldersUuids = null;
    @SerializedName("recentConverts")
    @Expose
    private Integer recentConverts;
    @SerializedName("recentConvertsEligibleForOrdination")
    @Expose
    private Integer recentConvertsEligibleForOrdination;
    @SerializedName("recentConvertsEligibleForOrdinationUuids")
    @Expose
    private List<String> recentConvertsEligibleForOrdinationUuids = null;
    @SerializedName("recentConvertsUuids")
    @Expose
    private List<String> recentConvertsUuids = null;
    @SerializedName("singleAdults")
    @Expose
    private Integer singleAdults;
    @SerializedName("singleAdultsUuids")
    @Expose
    private List<String> singleAdultsUuids = null;
    @SerializedName("teachers")
    @Expose
    private Integer teachers;
    @SerializedName("teachersUuids")
    @Expose
    private List<String> teachersUuids = null;
    @SerializedName("totalMembers")
    @Expose
    private Integer totalMembers;
    @SerializedName("totalMembersUuids")
    @Expose
    private List<String> totalMembersUuids = null;
    @SerializedName("unitNumber")
    @Expose
    private Integer unitNumber;
    @SerializedName("unordainedRecentConverts")
    @Expose
    private Integer unordainedRecentConverts;
    @SerializedName("unordainedRecentConvertsUuids")
    @Expose
    private List<String> unordainedRecentConvertsUuids = null;
    @SerializedName("women")
    @Expose
    private Integer women;
    @SerializedName("womenUuids")
    @Expose
    private List<String> womenUuids = null;
    @SerializedName("youngMen")
    @Expose
    private Integer youngMen;
    @SerializedName("youngMenRecentConverts")
    @Expose
    private Integer youngMenRecentConverts;
    @SerializedName("youngMenRecentConvertsUuids")
    @Expose
    private List<String> youngMenRecentConvertsUuids = null;
    @SerializedName("youngMenUuids")
    @Expose
    private List<String> youngMenUuids = null;
    @SerializedName("youngSingleAdults")
    @Expose
    private Integer youngSingleAdults;
    @SerializedName("youngSingleAdultsUuids")
    @Expose
    private List<String> youngSingleAdultsUuids = null;
    @SerializedName("youngWomen")
    @Expose
    private Integer youngWomen;
    @SerializedName("youngWomen12_13")
    @Expose
    private Integer youngWomen1213;
    @SerializedName("youngWomen12_13Uuids")
    @Expose
    private List<String> youngWomen1213Uuids = null;
    @SerializedName("youngWomen14_15")
    @Expose
    private Integer youngWomen1415;
    @SerializedName("youngWomen14_15Uuids")
    @Expose
    private List<String> youngWomen1415Uuids = null;
    @SerializedName("youngWomen16_17")
    @Expose
    private Integer youngWomen1617;
    @SerializedName("youngWomen16_17Uuids")
    @Expose
    private List<String> youngWomen1617Uuids = null;
    @SerializedName("youngWomenRecentConverts")
    @Expose
    private Integer youngWomenRecentConverts;
    @SerializedName("youngWomenRecentConvertsUuids")
    @Expose
    private List<String> youngWomenRecentConvertsUuids = null;
    @SerializedName("youngWomenUuids")
    @Expose
    private List<String> youngWomenUuids = null;

    public Integer getAdultFemaleRecentConverts() {
        return adultFemaleRecentConverts;
    }

    public void setAdultFemaleRecentConverts(Integer adultFemaleRecentConverts) {
        this.adultFemaleRecentConverts = adultFemaleRecentConverts;
    }

    public List<String> getAdultFemaleRecentConvertsUuids() {
        return adultFemaleRecentConvertsUuids;
    }

    public void setAdultFemaleRecentConvertsUuids(List<String> adultFemaleRecentConvertsUuids) {
        this.adultFemaleRecentConvertsUuids = adultFemaleRecentConvertsUuids;
    }

    public Integer getAdultMaleRecentConverts() {
        return adultMaleRecentConverts;
    }

    public void setAdultMaleRecentConverts(Integer adultMaleRecentConverts) {
        this.adultMaleRecentConverts = adultMaleRecentConverts;
    }

    public List<String> getAdultMaleRecentConvertsUuids() {
        return adultMaleRecentConvertsUuids;
    }

    public void setAdultMaleRecentConvertsUuids(List<String> adultMaleRecentConvertsUuids) {
        this.adultMaleRecentConvertsUuids = adultMaleRecentConvertsUuids;
    }

    public Integer getAdults() {
        return adults;
    }

    public void setAdults(Integer adults) {
        this.adults = adults;
    }

    public List<String> getAdultsUuids() {
        return adultsUuids;
    }

    public void setAdultsUuids(List<String> adultsUuids) {
        this.adultsUuids = adultsUuids;
    }

    public Integer getBaptizedNotConfirmed() {
        return baptizedNotConfirmed;
    }

    public void setBaptizedNotConfirmed(Integer baptizedNotConfirmed) {
        this.baptizedNotConfirmed = baptizedNotConfirmed;
    }

    public List<String> getBaptizedNotConfirmedUuids() {
        return baptizedNotConfirmedUuids;
    }

    public void setBaptizedNotConfirmedUuids(List<String> baptizedNotConfirmedUuids) {
        this.baptizedNotConfirmedUuids = baptizedNotConfirmedUuids;
    }

    public Integer getChildren() {
        return children;
    }

    public void setChildren(Integer children) {
        this.children = children;
    }

    public Integer getChildrenAge8to11RecentConverts() {
        return childrenAge8to11RecentConverts;
    }

    public void setChildrenAge8to11RecentConverts(Integer childrenAge8to11RecentConverts) {
        this.childrenAge8to11RecentConverts = childrenAge8to11RecentConverts;
    }

    public List<String> getChildrenAge8to11RecentConvertsUuids() {
        return childrenAge8to11RecentConvertsUuids;
    }

    public void setChildrenAge8to11RecentConvertsUuids(List<String> childrenAge8to11RecentConvertsUuids) {
        this.childrenAge8to11RecentConvertsUuids = childrenAge8to11RecentConvertsUuids;
    }

    public List<String> getChildrenUuids() {
        return childrenUuids;
    }

    public void setChildrenUuids(List<String> childrenUuids) {
        this.childrenUuids = childrenUuids;
    }

    public Integer getDeacons() {
        return deacons;
    }

    public void setDeacons(Integer deacons) {
        this.deacons = deacons;
    }

    public List<String> getDeaconsUuids() {
        return deaconsUuids;
    }

    public void setDeaconsUuids(List<String> deaconsUuids) {
        this.deaconsUuids = deaconsUuids;
    }

    public Integer getElders() {
        return elders;
    }

    public void setElders(Integer elders) {
        this.elders = elders;
    }

    public List<String> getEldersUuids() {
        return eldersUuids;
    }

    public void setEldersUuids(List<String> eldersUuids) {
        this.eldersUuids = eldersUuids;
    }

    public Integer getEndowedAdults() {
        return endowedAdults;
    }

    public void setEndowedAdults(Integer endowedAdults) {
        this.endowedAdults = endowedAdults;
    }

    public List<String> getEndowedAdultsUuids() {
        return endowedAdultsUuids;
    }

    public void setEndowedAdultsUuids(List<String> endowedAdultsUuids) {
        this.endowedAdultsUuids = endowedAdultsUuids;
    }

    public Integer getEndowedWithRecommend() {
        return endowedWithRecommend;
    }

    public void setEndowedWithRecommend(Integer endowedWithRecommend) {
        this.endowedWithRecommend = endowedWithRecommend;
    }

    public List<String> getEndowedWithRecommendUuids() {
        return endowedWithRecommendUuids;
    }

    public void setEndowedWithRecommendUuids(List<String> endowedWithRecommendUuids) {
        this.endowedWithRecommendUuids = endowedWithRecommendUuids;
    }

    public Integer getEndowedWithoutRecommend() {
        return endowedWithoutRecommend;
    }

    public void setEndowedWithoutRecommend(Integer endowedWithoutRecommend) {
        this.endowedWithoutRecommend = endowedWithoutRecommend;
    }

    public List<String> getEndowedWithoutRecommendUuids() {
        return endowedWithoutRecommendUuids;
    }

    public void setEndowedWithoutRecommendUuids(List<String> endowedWithoutRecommendUuids) {
        this.endowedWithoutRecommendUuids = endowedWithoutRecommendUuids;
    }

    public Integer getHighPriests() {
        return highPriests;
    }

    public void setHighPriests(Integer highPriests) {
        this.highPriests = highPriests;
    }

    public List<String> getHighPriestsUuids() {
        return highPriestsUuids;
    }

    public void setHighPriestsUuids(List<String> highPriestsUuids) {
        this.highPriestsUuids = highPriestsUuids;
    }

    public Integer getHouseholds() {
        return households;
    }

    public void setHouseholds(Integer households) {
        this.households = households;
    }

    public List<String> getHouseholdsUuids() {
        return householdsUuids;
    }

    public void setHouseholdsUuids(List<String> householdsUuids) {
        this.householdsUuids = householdsUuids;
    }

    public Integer getHouseholdsWithChildren() {
        return householdsWithChildren;
    }

    public void setHouseholdsWithChildren(Integer householdsWithChildren) {
        this.householdsWithChildren = householdsWithChildren;
    }

    public List<String> getHouseholdsWithChildrenUuids() {
        return householdsWithChildrenUuids;
    }

    public void setHouseholdsWithChildrenUuids(List<String> householdsWithChildrenUuids) {
        this.householdsWithChildrenUuids = householdsWithChildrenUuids;
    }

    public Integer getHouseholdsWithSingleParentAndYouthOrChildren() {
        return householdsWithSingleParentAndYouthOrChildren;
    }

    public void setHouseholdsWithSingleParentAndYouthOrChildren(Integer householdsWithSingleParentAndYouthOrChildren) {
        this.householdsWithSingleParentAndYouthOrChildren = householdsWithSingleParentAndYouthOrChildren;
    }

    public List<String> getHouseholdsWithSingleParentAndYouthOrChildrenUuids() {
        return householdsWithSingleParentAndYouthOrChildrenUuids;
    }

    public void setHouseholdsWithSingleParentAndYouthOrChildrenUuids(List<String> householdsWithSingleParentAndYouthOrChildrenUuids) {
        this.householdsWithSingleParentAndYouthOrChildrenUuids = householdsWithSingleParentAndYouthOrChildrenUuids;
    }

    public Integer getHouseholdsWithYouth() {
        return householdsWithYouth;
    }

    public void setHouseholdsWithYouth(Integer householdsWithYouth) {
        this.householdsWithYouth = householdsWithYouth;
    }

    public List<String> getHouseholdsWithYouthUuids() {
        return householdsWithYouthUuids;
    }

    public void setHouseholdsWithYouthUuids(List<String> householdsWithYouthUuids) {
        this.householdsWithYouthUuids = householdsWithYouthUuids;
    }

    public Integer getHouseholdsWithoutMelchizedekPriesthoodHolder() {
        return householdsWithoutMelchizedekPriesthoodHolder;
    }

    public void setHouseholdsWithoutMelchizedekPriesthoodHolder(Integer householdsWithoutMelchizedekPriesthoodHolder) {
        this.householdsWithoutMelchizedekPriesthoodHolder = householdsWithoutMelchizedekPriesthoodHolder;
    }

    public List<String> getHouseholdsWithoutMelchizedekPriesthoodHolderUuids() {
        return householdsWithoutMelchizedekPriesthoodHolderUuids;
    }

    public void setHouseholdsWithoutMelchizedekPriesthoodHolderUuids(List<String> householdsWithoutMelchizedekPriesthoodHolderUuids) {
        this.householdsWithoutMelchizedekPriesthoodHolderUuids = householdsWithoutMelchizedekPriesthoodHolderUuids;
    }

    public Integer getIndividualsNotIncluded() {
        return individualsNotIncluded;
    }

    public void setIndividualsNotIncluded(Integer individualsNotIncluded) {
        this.individualsNotIncluded = individualsNotIncluded;
    }

    public List<String> getIndividualsNotIncludedUuids() {
        return individualsNotIncludedUuids;
    }

    public void setIndividualsNotIncludedUuids(List<String> individualsNotIncludedUuids) {
        this.individualsNotIncludedUuids = individualsNotIncludedUuids;
    }

    public Integer getInfants() {
        return infants;
    }

    public void setInfants(Integer infants) {
        this.infants = infants;
    }

    public List<String> getInfantsUuids() {
        return infantsUuids;
    }

    public void setInfantsUuids(List<String> infantsUuids) {
        this.infantsUuids = infantsUuids;
    }

    public Integer getInvalidBirthdate() {
        return invalidBirthdate;
    }

    public void setInvalidBirthdate(Integer invalidBirthdate) {
        this.invalidBirthdate = invalidBirthdate;
    }

    public List<String> getInvalidBirthdateUuids() {
        return invalidBirthdateUuids;
    }

    public void setInvalidBirthdateUuids(List<String> invalidBirthdateUuids) {
        this.invalidBirthdateUuids = invalidBirthdateUuids;
    }

    public Integer getMarriedAdults() {
        return marriedAdults;
    }

    public void setMarriedAdults(Integer marriedAdults) {
        this.marriedAdults = marriedAdults;
    }

    public List<String> getMarriedAdultsUuids() {
        return marriedAdultsUuids;
    }

    public void setMarriedAdultsUuids(List<String> marriedAdultsUuids) {
        this.marriedAdultsUuids = marriedAdultsUuids;
    }

    public Integer getMembersOfRecordAge9OrOlder() {
        return membersOfRecordAge9OrOlder;
    }

    public void setMembersOfRecordAge9OrOlder(Integer membersOfRecordAge9OrOlder) {
        this.membersOfRecordAge9OrOlder = membersOfRecordAge9OrOlder;
    }

    public List<String> getMembersOfRecordAge9OrOlderUuids() {
        return membersOfRecordAge9OrOlderUuids;
    }

    public void setMembersOfRecordAge9OrOlderUuids(List<String> membersOfRecordAge9OrOlderUuids) {
        this.membersOfRecordAge9OrOlderUuids = membersOfRecordAge9OrOlderUuids;
    }

    public Integer getMen() {
        return men;
    }

    public void setMen(Integer men) {
        this.men = men;
    }

    public List<String> getMenUuids() {
        return menUuids;
    }

    public void setMenUuids(List<String> menUuids) {
        this.menUuids = menUuids;
    }

    public Integer getOrdainedRecentConverts() {
        return ordainedRecentConverts;
    }

    public void setOrdainedRecentConverts(Integer ordainedRecentConverts) {
        this.ordainedRecentConverts = ordainedRecentConverts;
    }

    public List<String> getOrdainedRecentConvertsUuids() {
        return ordainedRecentConvertsUuids;
    }

    public void setOrdainedRecentConvertsUuids(List<String> ordainedRecentConvertsUuids) {
        this.ordainedRecentConvertsUuids = ordainedRecentConvertsUuids;
    }

    public Integer getPriests() {
        return priests;
    }

    public void setPriests(Integer priests) {
        this.priests = priests;
    }

    public List<String> getPriestsUuids() {
        return priestsUuids;
    }

    public void setPriestsUuids(List<String> priestsUuids) {
        this.priestsUuids = priestsUuids;
    }

    public Integer getProspectiveElders() {
        return prospectiveElders;
    }

    public void setProspectiveElders(Integer prospectiveElders) {
        this.prospectiveElders = prospectiveElders;
    }

    public List<String> getProspectiveEldersUuids() {
        return prospectiveEldersUuids;
    }

    public void setProspectiveEldersUuids(List<String> prospectiveEldersUuids) {
        this.prospectiveEldersUuids = prospectiveEldersUuids;
    }

    public Integer getRecentConverts() {
        return recentConverts;
    }

    public void setRecentConverts(Integer recentConverts) {
        this.recentConverts = recentConverts;
    }

    public Integer getRecentConvertsEligibleForOrdination() {
        return recentConvertsEligibleForOrdination;
    }

    public void setRecentConvertsEligibleForOrdination(Integer recentConvertsEligibleForOrdination) {
        this.recentConvertsEligibleForOrdination = recentConvertsEligibleForOrdination;
    }

    public List<String> getRecentConvertsEligibleForOrdinationUuids() {
        return recentConvertsEligibleForOrdinationUuids;
    }

    public void setRecentConvertsEligibleForOrdinationUuids(List<String> recentConvertsEligibleForOrdinationUuids) {
        this.recentConvertsEligibleForOrdinationUuids = recentConvertsEligibleForOrdinationUuids;
    }

    public List<String> getRecentConvertsUuids() {
        return recentConvertsUuids;
    }

    public void setRecentConvertsUuids(List<String> recentConvertsUuids) {
        this.recentConvertsUuids = recentConvertsUuids;
    }

    public Integer getSingleAdults() {
        return singleAdults;
    }

    public void setSingleAdults(Integer singleAdults) {
        this.singleAdults = singleAdults;
    }

    public List<String> getSingleAdultsUuids() {
        return singleAdultsUuids;
    }

    public void setSingleAdultsUuids(List<String> singleAdultsUuids) {
        this.singleAdultsUuids = singleAdultsUuids;
    }

    public Integer getTeachers() {
        return teachers;
    }

    public void setTeachers(Integer teachers) {
        this.teachers = teachers;
    }

    public List<String> getTeachersUuids() {
        return teachersUuids;
    }

    public void setTeachersUuids(List<String> teachersUuids) {
        this.teachersUuids = teachersUuids;
    }

    public Integer getTotalMembers() {
        return totalMembers;
    }

    public void setTotalMembers(Integer totalMembers) {
        this.totalMembers = totalMembers;
    }

    public List<String> getTotalMembersUuids() {
        return totalMembersUuids;
    }

    public void setTotalMembersUuids(List<String> totalMembersUuids) {
        this.totalMembersUuids = totalMembersUuids;
    }

    public Integer getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(Integer unitNumber) {
        this.unitNumber = unitNumber;
    }

    public Integer getUnordainedRecentConverts() {
        return unordainedRecentConverts;
    }

    public void setUnordainedRecentConverts(Integer unordainedRecentConverts) {
        this.unordainedRecentConverts = unordainedRecentConverts;
    }

    public List<String> getUnordainedRecentConvertsUuids() {
        return unordainedRecentConvertsUuids;
    }

    public void setUnordainedRecentConvertsUuids(List<String> unordainedRecentConvertsUuids) {
        this.unordainedRecentConvertsUuids = unordainedRecentConvertsUuids;
    }

    public Integer getWomen() {
        return women;
    }

    public void setWomen(Integer women) {
        this.women = women;
    }

    public List<String> getWomenUuids() {
        return womenUuids;
    }

    public void setWomenUuids(List<String> womenUuids) {
        this.womenUuids = womenUuids;
    }

    public Integer getYoungMen() {
        return youngMen;
    }

    public void setYoungMen(Integer youngMen) {
        this.youngMen = youngMen;
    }

    public Integer getYoungMenRecentConverts() {
        return youngMenRecentConverts;
    }

    public void setYoungMenRecentConverts(Integer youngMenRecentConverts) {
        this.youngMenRecentConverts = youngMenRecentConverts;
    }

    public List<String> getYoungMenRecentConvertsUuids() {
        return youngMenRecentConvertsUuids;
    }

    public void setYoungMenRecentConvertsUuids(List<String> youngMenRecentConvertsUuids) {
        this.youngMenRecentConvertsUuids = youngMenRecentConvertsUuids;
    }

    public List<String> getYoungMenUuids() {
        return youngMenUuids;
    }

    public void setYoungMenUuids(List<String> youngMenUuids) {
        this.youngMenUuids = youngMenUuids;
    }

    public Integer getYoungSingleAdults() {
        return youngSingleAdults;
    }

    public void setYoungSingleAdults(Integer youngSingleAdults) {
        this.youngSingleAdults = youngSingleAdults;
    }

    public List<String> getYoungSingleAdultsUuids() {
        return youngSingleAdultsUuids;
    }

    public void setYoungSingleAdultsUuids(List<String> youngSingleAdultsUuids) {
        this.youngSingleAdultsUuids = youngSingleAdultsUuids;
    }

    public Integer getYoungWomen() {
        return youngWomen;
    }

    public void setYoungWomen(Integer youngWomen) {
        this.youngWomen = youngWomen;
    }

    public Integer getYoungWomen1213() {
        return youngWomen1213;
    }

    public void setYoungWomen1213(Integer youngWomen1213) {
        this.youngWomen1213 = youngWomen1213;
    }

    public List<String> getYoungWomen1213Uuids() {
        return youngWomen1213Uuids;
    }

    public void setYoungWomen1213Uuids(List<String> youngWomen1213Uuids) {
        this.youngWomen1213Uuids = youngWomen1213Uuids;
    }

    public Integer getYoungWomen1415() {
        return youngWomen1415;
    }

    public void setYoungWomen1415(Integer youngWomen1415) {
        this.youngWomen1415 = youngWomen1415;
    }

    public List<String> getYoungWomen1415Uuids() {
        return youngWomen1415Uuids;
    }

    public void setYoungWomen1415Uuids(List<String> youngWomen1415Uuids) {
        this.youngWomen1415Uuids = youngWomen1415Uuids;
    }

    public Integer getYoungWomen1617() {
        return youngWomen1617;
    }

    public void setYoungWomen1617(Integer youngWomen1617) {
        this.youngWomen1617 = youngWomen1617;
    }

    public List<String> getYoungWomen1617Uuids() {
        return youngWomen1617Uuids;
    }

    public void setYoungWomen1617Uuids(List<String> youngWomen1617Uuids) {
        this.youngWomen1617Uuids = youngWomen1617Uuids;
    }

    public Integer getYoungWomenRecentConverts() {
        return youngWomenRecentConverts;
    }

    public void setYoungWomenRecentConverts(Integer youngWomenRecentConverts) {
        this.youngWomenRecentConverts = youngWomenRecentConverts;
    }

    public List<String> getYoungWomenRecentConvertsUuids() {
        return youngWomenRecentConvertsUuids;
    }

    public void setYoungWomenRecentConvertsUuids(List<String> youngWomenRecentConvertsUuids) {
        this.youngWomenRecentConvertsUuids = youngWomenRecentConvertsUuids;
    }

    public List<String> getYoungWomenUuids() {
        return youngWomenUuids;
    }

    public void setYoungWomenUuids(List<String> youngWomenUuids) {
        this.youngWomenUuids = youngWomenUuids;
    }

}
