/**
 * 
 */
package com.inova.banheirolimpo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Component;

/**
 * @author Markus Souza
 * @since 08/11/2017
 *
 */

@Component
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class SpringAuditingConfig {
	
	@Bean
	public AuditorAware<String> auditorAware() {
		return new SpringSecurityAuditor();
	}
}
