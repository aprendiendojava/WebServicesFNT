package dev.fnt.spboot.holidays.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import dev.fnt.spboot.holidays.persist.repo.ext.ReflexSearchImpl;

@Configuration
@EnableJpaRepositories(basePackages = {"dev.fnt.spboot.holidays.persist.repo"}, repositoryBaseClass=ReflexSearchImpl.class)
@EnableTransactionManagement
public class PersistenceContext {

}
