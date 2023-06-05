package com.jdriven;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.data.repository.query.SecurityEvaluationContextExtension;

@Configuration
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
	// TODO Integrate Spring Data with Spring Security, expand on the security expression in PreferencesRepository, and
	// have the restrictions enforced by Spring Security

    public SecurityEvaluationContextExtension securityEvaluationContextExtension() {
        return new SecurityEvaluationContextExtension();
    }
}
