package com.jdriven.access;

import com.jdriven.model.Spreadsheet;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.vote.AbstractAclVoter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.util.Collection;
@Component
public class SpreadsheetAccessDecisionVoter extends AbstractAclVoter {

    private final SpreadsheetAccessStore store;

    public SpreadsheetAccessDecisionVoter(SpreadsheetAccessStore store) {
        this.store = store;
        setProcessDomainObjectClass(Spreadsheet.class);
    }
    @Override
    public boolean supports(ConfigAttribute attribute) {
        return getProcessDomainObjectClass().getName().equals(attribute.getAttribute());
    }

    @Override
    public int vote(Authentication authentication, MethodInvocation methodInvocation, Collection<ConfigAttribute> attributes) {
        for (ConfigAttribute configAttribute : attributes) {
            if (supports(configAttribute)) {
                User principal = (User) authentication.getPrincipal();
                Spreadsheet domainObjectInstance = (Spreadsheet) getDomainObjectInstance(methodInvocation);
                return hasSpreadsheetAccess(principal, domainObjectInstance) ? ACCESS_GRANTED : ACCESS_DENIED;
            }
        }
        return ACCESS_ABSTAIN;
    }

    private boolean hasSpreadsheetAccess(User principal, Spreadsheet domainObjectInstance) {
        return store.getAccess().stream().anyMatch(p -> p.getUser().equals(principal) && p.getSpreadsheet().equals(domainObjectInstance));
    }
}
