package org.xcolab.view.config.rewrite.rules.legacy;

import org.ocpsoft.rewrite.config.ConfigurationBuilder;
import org.ocpsoft.rewrite.config.Direction;
import org.ocpsoft.rewrite.servlet.config.Path;
import org.ocpsoft.rewrite.servlet.config.Redirect;

import org.xcolab.view.config.rewrite.rules.RewriteRuleProvider;

public class LegacyProposalRewriteRules implements RewriteRuleProvider {

    @Override
    public void configure(ConfigurationBuilder configurationBuilder) {
        configurationBuilder
                .addRule()
                    .when(Direction.isInbound()
                            .and(Path.matches("/web/guest/{portletName}")))
                    .perform(Redirect.permanent("/contests"))
                    .where("portletName").matches("(plans|dialogues|challenges|trends)")
                .addRule()
                    .when(Direction.isInbound()
                            .and(Path.matches("/web/guest/plans/-/plans/contestsType/prior")))
                    .perform(Redirect.permanent("/contests?viewType=GRID&showAllContests=true"))
                .addRule()
                    .when(Direction.isInbound()
                            .and(Path.matches("/web/guest/plans/-/plans/contestsType/all")))
                    .perform(Redirect.permanent("/contests?viewType=GRID&showAllContests=true"))
                .addRule()
                    .when(Direction.isInbound()
                            .and(Path.matches("/plans")))
                    .perform(Redirect.permanent("/contests"));

        // legacy urls
        configurationBuilder
                .addRule()
                    .when(Direction.isInbound().and(
                            Path.matches("/web/guest/{portletName}/-/plans/contestId/{contestId}")
                                    .or(Path.matches("/{portletName}/-/plans/contestId/{contestId}"))
                                    .or(Path.matches("/web/guest/{portletName}/-/plans/contestId/{contestId}/page/{pageName}"))
                                    .or(Path.matches("/{portletName}/-/plans/contestId/{contestId}/page/{pageName}"))))
                    .perform(Redirect.temporary("/contests/legacy/contest/{contestId}"))
                    .where("portletName").matches("(plans|dialogues|challenges|trends)")
                .addRule()
                    .when(Direction.isInbound().and(
                            Path.matches("/web/guest/{portletName}/-/plans/contestId/{contestId}/phase/{phaseId}")
                                .or(Path.matches("/{portletName}/-/plans/contestId/{contestId}/phase/{phaseId}"))))
                    .perform(Redirect.temporary("/contests/legacy/contest/{contestId}"))
                    .where("portletName").matches("(plans|dialogues|challenges|trends)")
                .addRule()
                    .when(Direction.isInbound().and(
                            Path.matches("/web/guest/{portletName}/-/plans/contestId/{contestId}/planId/{proposalId}")
                                    .or(Path.matches("/{portletName}/-/plans/contestId/{contestId}/planId/{proposalId}"))
                                    .or(Path.matches("/web/guest/{portletName}/-/plans/contestId/{contestId}/planId/{proposalId}/{path}"))
                                    .or(Path.matches("/{portletName}/-/plans/contestId/{contestId}/planId/{proposalId}/{path}"))
                    ))
                    .perform(Redirect.temporary("/contests/legacy/contest/{contestId}/proposal/{proposalId}"))
                    .where("portletName").matches("(plans|dialogues|challenges|trends)")
                    .where("path").matches(".*")
                .addRule()
                    .when(Direction.isInbound().and(
                            Path.matches("/web/guest/{portletName}/-/plans/contestId/{contestId}/phaseId/{phaseId}/planId/{proposalId}")
                                    .or(Path.matches("/{portletName}/-/plans/contestId/{contestId}/phaseId/{phaseId}/planId/{proposalId}"))
                                    .or(Path.matches("/web/guest/{portletName}/-/plans/contestId/{contestId}/phaseId/{phaseId}/planId/{proposalId}/{path}"))
                                    .or(Path.matches("/{portletName}/-/plans/contestId/{contestId}/phaseId/{phaseId}/planId/{proposalId}/{path}"))
                    ))
                    .perform(Redirect.temporary("/contests/legacy/contest/{contestId}/proposal/{proposalId}?phaseId={phaseId}"))
                    .where("portletName").matches("(plans|dialogues|challenges|trends)")
                    .where("path").matches(".*")
                .addRule()
                    .when(Direction.isInbound().and(
                            Path.matches("/web/guest/plans/-/plans/contests{path}")
                                .or(Path.matches("/plans/-/plans/contests{path}"))
                    ))
                    .perform(Redirect.permanent("/contests{path}"))
                    .where("path").matches(".*")
                .addRule()
                    .when(Direction.isInbound().and(Path.matches("/web/guest/proposals")))
                    .perform(Redirect.permanent("/contests"));
    }
}
