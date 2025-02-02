package org.xcolab.view.pages.contestmanagement.beans;

import org.xcolab.client.contest.ContestClientUtil;
import org.xcolab.client.contest.pojo.Contest;
import org.xcolab.view.pages.contestmanagement.wrappers.WikiPageWrapper;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class ContestAdminBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String emailTemplateUrl;
    private ContestModelSettingsBean contestModelSettings;

    private boolean hideRibbons;
    private boolean readOnlyComments;

    @NotNull(message = "A contest URL name must be specified")
    private String contestUrlName;

    @NotNull(message = "A contest year must be specified")
    private Long contestYear;

    @NotNull(message = "A contest tier must be selected.")
    private Long contestTier;

    @NotNull(message = "A contest type must be selected.")
    private Long contestType;


    public ContestAdminBean() { }

    public ContestAdminBean(Contest contest) {
        if (contest != null) {
            contestUrlName = contest.getContestUrlName();
            contestYear = contest.getContestYear();
            contestTier = contest.getContestTier();
            contestType = contest.getContestTypeId();
            readOnlyComments = contest.getReadOnlyComments();
            hideRibbons = contest.getHideRibbons();
            emailTemplateUrl = contest.getEmailTemplateUrl();
            contestModelSettings = new ContestModelSettingsBean(contest);
        }
    }

    public void persist(Contest contest) {

        updateContest(contest);
        WikiPageWrapper.updateContestWiki(contest);
    }

    private void updateContest(Contest contest) {
        contest.setContestUrlName(contestUrlName);
        contest.setContestYear(contestYear);
        contest.setEmailTemplateUrl(emailTemplateUrl);
        contest.setContestTier(contestTier);
        contest.setContestTypeId(contestType);
        contest.setHideRibbons(hideRibbons);
        contest.setReadOnlyComments(readOnlyComments);

        ContestClientUtil.updateContest(contest);

        contestModelSettings.persist(contest);
    }

    public String getEmailTemplateUrl() {
        if (emailTemplateUrl != null) {
            return emailTemplateUrl;
        } else {
            return "";
        }
    }

    public void setEmailTemplateUrl(String emailTemplateUrl) {
        this.emailTemplateUrl = emailTemplateUrl;
    }

    public String getContestUrlName() {
        return contestUrlName;
    }

    public void setContestUrlName(String contestUrlName) {
        this.contestUrlName = contestUrlName;
    }

    public Long getContestYear() {
        return contestYear;
    }

    public void setContestYear(Long contestYear) {
        this.contestYear = contestYear;
    }

    public Long getContestTier() {
        return contestTier;
    }

    public void setContestTier(Long contestTier) {
        this.contestTier = contestTier;
    }

    public Long getContestType() {
        return contestType;
    }

    public void setContestType(Long contestType) {
        this.contestType = contestType;
    }

    public ContestModelSettingsBean getContestModelSettings() {
        return contestModelSettings;
    }

    public void setContestModelSettings(ContestModelSettingsBean contestModelSettings) {
        this.contestModelSettings = contestModelSettings;
    }

    public boolean isHideRibbons() {
        return hideRibbons;
    }

    public void setHideRibbons(boolean hideRibbons) {
        this.hideRibbons = hideRibbons;
    }

    public boolean isReadOnlyComments() { return readOnlyComments; }

    public void setReadOnlyComments(boolean readOnlyComments) {
        this.readOnlyComments = readOnlyComments;
    }
}
