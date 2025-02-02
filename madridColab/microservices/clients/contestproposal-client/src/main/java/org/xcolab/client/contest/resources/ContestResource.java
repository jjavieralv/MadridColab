package org.xcolab.client.contest.resources;

import org.xcolab.util.http.client.CoLabService;
import org.xcolab.util.http.client.enums.ResourceEnum;

public enum ContestResource implements ResourceEnum {
    CONTEST("contests"),
    CONTEST_PHASE("contestPhases"),
    CONTEST_PHASE_TYPE("contestPhaseTypes"),
    CONTEST_PHASE_RIBBON_TYPE("contestPhaseRibbonTypes"),
    CONTEST_SCHEDULE("contestSchedules"),
    CONTEST_DISCUSSION("contestDiscussions"),
    CONTEST_COLLECTION_CARDS("contestCollectionCards"),

    CONTEST_TEAM_MEMBER("contestTeamMembers"),
    CONTEST_TEAM_MEMBER_ROLE("contestTeamMemberRoles"),

    PLAN_TEMPLATE("proposalTemplates"),
    PLAN_TEMPLATE_SECTION("proposalTemplateSections"),
    PLAN_SECTION_DEFINITION("proposalTemplateSectionDefinitions"),

    POINT_TYPE("pointTypes"),
    POINTS_DISTRIBUTION_CONFIGURATION("pointsDistributionConfigurations"),

    //TODO COLAB-2594: rethink this endpoint
    CONTEST_YEAR("contestyears"),
    CONTEST_FUSION("contestFusion")
    ;

    private final String resourceName;

    ContestResource(String resourceName) {
        this.resourceName = resourceName;
    }

    @Override
    public String getResourceName() {
        return resourceName;
    }

    @Override
    public CoLabService getCoLabService() {
        return CoLabService.CONTEST;
    }
}
