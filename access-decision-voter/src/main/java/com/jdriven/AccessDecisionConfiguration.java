package com.jdriven;

import com.jdriven.access.SpreadsheetAccessDecisionVoter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.vote.AbstractAccessDecisionManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class AccessDecisionConfiguration extends GlobalMethodSecurityConfiguration {
	// TODO: Have the @Secured annotation on SpreadsheetService#read(Spreadsheet) check access against permissions stored
	// in SpreadsheetAccessStore
    @Autowired
    private SpreadsheetAccessDecisionVoter voter;

    @Override
    protected AccessDecisionManager accessDecisionManager() {
        AbstractAccessDecisionManager superManager = (AbstractAccessDecisionManager) super.accessDecisionManager();
        superManager.getDecisionVoters().add(voter);
        return superManager;
    }
}
