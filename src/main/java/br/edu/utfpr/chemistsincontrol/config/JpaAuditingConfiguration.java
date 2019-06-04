package br.edu.utfpr.chemistsincontrol.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

/**
 * Classe para configuração da auditoria (@CreatedBy e @LastModifiedBy)
 */
@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class JpaAuditingConfiguration {

    public static final ThreadLocal<Long> _user = new ThreadLocal<>();

    @Bean
    public AuditorAware<Long> auditorProvider() {
        return () -> Optional.ofNullable(_user.get());
    }

}
