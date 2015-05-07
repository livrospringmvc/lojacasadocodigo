package br.com.casadocodigo.loja.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.net.URISyntaxException;

@Profile("prod")
public class JPAProductionConfiguration {

    @Autowired
    private Environment environment;

    @Bean
    public DataSource dataSource() throws URISyntaxException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(this.environment.getProperty("loja.configuracao.prod.database.drive"));
        dataSource.setUrl(this.environment.getProperty("loja.configuracao.prod.database.url"));
        dataSource.setUsername(this.environment.getProperty("loja.configuracao.prod.database.username"));
        dataSource.setPassword(this.environment.getProperty("loja.configuracao.prod.database.password"));
        return dataSource;
    }
}
