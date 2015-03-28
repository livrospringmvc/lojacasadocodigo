package br.com.casadocodigo.loja.conf;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DataSourceConfigurationTest {

	   @Bean	 
	   @Profile("test")
	   public DataSource dataSource(){
		   DriverManagerDataSource dataSource = new DriverManagerDataSource();
		   dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		   dataSource.setUrl("jdbc:mysql://localhost:3306/casadocodigo_test");
		   dataSource.setUsername( "root" );
		   dataSource.setPassword( "" );
		   return dataSource;
	   }
}
