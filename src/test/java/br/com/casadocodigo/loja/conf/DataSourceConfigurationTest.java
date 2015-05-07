package br.com.casadocodigo.loja.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:application-test.properties")
public class DataSourceConfigurationTest {

    @Autowired
    private Environment environment;

    @Bean
    @Profile("test")

    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(this.environment.getProperty("loja.configuracao.test.database.drive"));
        dataSource.setUrl(this.environment.getProperty("loja.configuracao.test.database.url"));
        dataSource.setUsername(this.environment.getProperty("loja.configuracao.test.database.username"));
        dataSource.setPassword(this.environment.getProperty("loja.configuracao.test.database.password"));
        return dataSource;
    }
}
