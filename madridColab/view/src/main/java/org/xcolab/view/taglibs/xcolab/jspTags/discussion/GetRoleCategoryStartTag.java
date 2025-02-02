package org.xcolab.view.taglibs.xcolab.jspTags.discussion;

import org.xcolab.client.members.MembersClient;
import org.xcolab.client.members.exceptions.MemberNotFoundException;
import org.xcolab.client.members.pojo.Member;
import org.xcolab.client.members.pojo.MemberCategory;
import org.xcolab.client.proposals.ProposalClient;
import org.xcolab.client.proposals.ProposalClientUtil;
import org.xcolab.commons.exceptions.ReferenceResolutionException;

import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class GetRoleCategoryStartTag extends BodyTagSupport {

    private long userId;

    private long proposalId;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getProposalId() {
        return proposalId;
    }

    public void setProposalId(long proposalId) {
        this.proposalId = proposalId;
    }

    private ProposalClient proposalClient = ProposalClientUtil.getClient();

    @Override
    public int doStartTag() throws JspException {
        try {
            Member member = MembersClient.getMember(userId);
            MemberCategory roleCategory = MembersClient.getHighestCategory(member.getRoles());
            pageContext.setAttribute("roleCategory", roleCategory);

            // Is the user contributing to the proposal?
            boolean isContributing = false;
            if (proposalId > 0) {
                List<Member> contributors = proposalClient.getProposalMembers(proposalId);
                for (Member contributor : contributors) {
                    if (contributor.getId() == userId) {
                        isContributing = true;
                        break;
                    }
                }
            }
            pageContext.setAttribute("isContributing", isContributing);

        } catch (MemberNotFoundException e) {
            throw ReferenceResolutionException.toObject(Member.class, userId)
                    .fromObject(GetRoleCategoryStartTag.class,
                            "user id " + userId + " proposalId " + proposalId);
        }
        return EVAL_BODY_INCLUDE;
    }
}
