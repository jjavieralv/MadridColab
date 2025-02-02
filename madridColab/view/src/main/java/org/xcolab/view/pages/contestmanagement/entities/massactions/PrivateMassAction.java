package org.xcolab.view.pages.contestmanagement.entities.massactions;

import org.xcolab.client.contest.pojo.Contest;

public class PrivateMassAction extends SetContestPropertyMassAction {

    public PrivateMassAction(boolean setValue) {
        super(setValue, "Private", "Public (not 'Private')");
    }

    @Override
    protected void setProperty(Contest contest, boolean setTrue) {
        contest.setContestPrivate(setTrue);
    }
}
