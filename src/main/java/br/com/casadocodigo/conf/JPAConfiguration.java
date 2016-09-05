package br.com.casadocodigo.conf;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
public class JPAConfiguration {

	@Autowired
	private Environment environment; 
	
	@Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws URISyntaxException {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();

        JpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();

        factoryBean.setJpaVendorAdapter(jpaVendorAdapter );
        
        // alterar a depender do banco
        factoryBean.setDataSource(dataSourceConfigMySql());
//        factoryBean.setDataSource(dataSourceConfigPostgreSQL());

        // alterar a depender do banco
        factoryBean.setJpaProperties(getPropertiesMySql());
//        factoryBean.setJpaProperties(getPropertiesPostgreSQL());
        

        factoryBean.setPackagesToScan("br.com.casadocodigo.model");

        return factoryBean;

    }

	@SuppressWarnings("unused")
	public DriverManagerDataSource dataSourceConfigMySql() {
	
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		dataSource.setUrl("jdbc:mysql://localhost:3306/casadocodigo");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		
		return dataSource;
	}
	
	public Properties getPropertiesMySql(){
		
		Properties props = new Properties();
		
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		props.setProperty("hibernate.show_sql", "true");
		props.setProperty("hibernate.hbm2ddl.auto", "update");
		
		return props; 
	}
	
	public DriverManagerDataSource dataSourceConfigPostgreSQL() throws URISyntaxException {

		// usuario:senha@host:port/path
		URI dbUrl = new URI(environment.getProperty("DATABASE_URL"));

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
				
		dataSource.setUrl("jdbc:postgresql://" + dbUrl.getHost() + ":" + dbUrl.getPort() + dbUrl.getPath()); 
		
		dataSource.setUsername(dbUrl.getUserInfo().split(":")[0]);
		dataSource.setPassword(dbUrl.getUserInfo().split(":")[1]);
							           
		dataSource.setDriverClassName("org.postgresql.Driver");
		
		return dataSource;
	}
	
	public Properties getPropertiesPostgreSQL() {
		
		Properties props = new Properties();
		
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		props.setProperty("hibernate.show_sql", "true");
		props.setProperty("hibernate.hbm2ddl.auto", "update");
		
		return props; 
	}
	
	@Bean
	public JpaTransactionManager transactionManager (EntityManagerFactory emf){
		return new JpaTransactionManager(emf);
	}
}
