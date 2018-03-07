package br.com.dogkit.persistence.configuration;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@ComponentScan(basePackages = "br.com.dogkit")
public class DataSourceConfiguration {

	@Bean
	public BasicDataSource getDataSource() {
		MysqlConfiguration mysqlConfiguration = getMysqlConfiguration();
		BasicDataSource dataSource = new BasicDataSource();
		/*dataSource.setDriverClassName(mysqlConfiguration.getDriver());
		dataSource.setUrl(mysqlConfiguration.getUrl());
		dataSource.setUsername(mysqlConfiguration.getUsuario());
		dataSource.setPassword(mysqlConfiguration.getSenha());*/
		return dataSource;
	}

	@Bean
	public JdbcTemplate getJdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		jdbcTemplate.afterPropertiesSet();
		return jdbcTemplate;
	}

	@Bean
	public MysqlConfiguration getMysqlConfiguration() {
		return new MysqlConfiguration();
	}

}
