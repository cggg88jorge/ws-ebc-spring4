package com.makingdevs.config

import javax.sql.DataSource

import org.springframework.jdbc.datasource.DriverManagerDataSource
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType

@Configuration
public class TramaDataSourceConfig {

  private static final String PROPERTY_NAME_DATABASE_URL = "jdbc:mysql://localhost:3306/trama"
  private static final String PROPERTY_NAME_DATABASE_DRIVER = "com.mysql.jdbc.Driver"
  private static final String PROPERTY_NAME_DATABASE_USERNAME = "root"
  private static final String PROPERTY_NAME_DATABASE_PASSWORD = ""

  @Bean
  public DataSource tramaDataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource()
    dataSource.setDriverClassName(PROPERTY_NAME_DATABASE_DRIVER)
    dataSource.setUrl(PROPERTY_NAME_DATABASE_URL)
    dataSource.setUsername(PROPERTY_NAME_DATABASE_USERNAME)
    dataSource.setPassword(PROPERTY_NAME_DATABASE_PASSWORD)
    dataSource
  }

  @Bean
  public JdbcTemplate jdbcTemplate(){
    return new JdbcTemplate(tramaDataSource())
  }

}

