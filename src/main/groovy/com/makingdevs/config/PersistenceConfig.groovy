package com.makingdevs.config

import javax.sql.DataSource

import org.springframework.jdbc.datasource.DriverManagerDataSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.JpaVendorAdapter
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.Database
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import org.springframework.transaction.PlatformTransactionManager

@Configuration
@EnableJpaRepositories(basePackages = [ "com.makingdevs.repositories" ])
public class PersistenceConfig {

  private static final String PROPERTY_NAME_DATABASE_URL = "jdbc:mysql://localhost:3306/dashboard"
  private static final String PROPERTY_NAME_DATABASE_DRIVER = "com.mysql.jdbc.Driver"
  private static final String PROPERTY_NAME_DATABASE_USERNAME = "root"
  private static final String PROPERTY_NAME_DATABASE_PASSWORD = ""

  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource()
    dataSource.setDriverClassName(PROPERTY_NAME_DATABASE_DRIVER)
    dataSource.setUrl(PROPERTY_NAME_DATABASE_URL)
    dataSource.setUsername(PROPERTY_NAME_DATABASE_USERNAME)
    dataSource.setPassword(PROPERTY_NAME_DATABASE_PASSWORD)
    dataSource
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
    LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean()
    lef.setDataSource(dataSource)
    lef.setJpaVendorAdapter(jpaVendorAdapter)
    lef.setPackagesToScan("com.makingdevs.domains")
    lef
  }

  @Bean
  public JpaVendorAdapter jpaVendorAdapter() {
    HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter()
    hibernateJpaVendorAdapter.setShowSql(false)
    //TODO: ESTO ESTÁ POR CUESTIONES DE EJEMPLO NO USAR EN NINGÚN PROYECTO
    // hibernateJpaVendorAdapter.setGenerateDdl(true)
    hibernateJpaVendorAdapter.setDatabase(Database.MYSQL)
    hibernateJpaVendorAdapter
  }

  @Bean
  public PlatformTransactionManager transactionManager() {
    new JpaTransactionManager()
  }
}

