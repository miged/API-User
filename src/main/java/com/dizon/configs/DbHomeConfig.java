package com.dizon.configs;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

//@PropertySource(value = "classpath:application.yml")
@Configuration
public class DbHomeConfig {
	
	@Value("${spring.datasource.driverClassName:com.microsoft.sqlserver.jdbc.SQLServerDriver}")
	String dbDriverClass;
	
	@Value("${spring.datasource.url}")
	String dbUrl;

	@Value("${spring.datasource.username}")
	String dbUsername;

	@Value("${spring.datasource.password}")
	String dbPassword;

	private static DataSource dataSource;

	@Bean
	void getJdbcTemplate() {

		dataSource = getDataSource();

		JdbcTemplate template = new JdbcTemplate();
		template.setDataSource(dataSource);
	}

    @Bean
    DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(dbDriverClass);
        dataSourceBuilder.url(dbUrl);
        dataSourceBuilder.username(dbUsername);
        dataSourceBuilder.password(dbPassword);
        return dataSourceBuilder.build();
    }
}
