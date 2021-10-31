package com.jamie.yozu.configuration;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;
import org.springframework.transaction.support.TransactionTemplate;

import com.jamie.yozu.exceptions.FailedToStartExeception;

@Configuration
public class DatabaseConfiguration implements TransactionManagementConfigurer {
  
  @Autowired
  DataSource dataSource;
  
  @Autowired
  private Environment environment;
  
  @Bean
  public HibernateTransactionManager transactionManager() throws IOException {
    HibernateTransactionManager manager = new HibernateTransactionManager();
    manager.setSessionFactory(sessionFactory());
    manager.setRollbackOnCommitFailure(true);
    return manager;
  }
  
  @Bean
  public TransactionTemplate TransactionTemplate() {
    TransactionTemplate template = new TransactionTemplate();
    template.setPropagationBehavior(0);
    return template;
  }
  
  @Bean
  public SessionFactory sessionFactory() throws IOException {
    LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
    localSessionFactoryBean.setDataSource(dataSource);
    Properties hibernateProps = new Properties();
    hibernateProps.setProperty("hibernate.dialect", environment.getProperty("hibenate.dialect"));
    hibernateProps.setProperty("hibernate.current_session_context_class", 
                               environment.getProperty("hibernate.current_session_context_class"));
    hibernateProps.setProperty("hibernate.id.new_generator_mappings", 
                               environment.getProperty("hibernate.id.new_generator_mappings"));
    
    localSessionFactoryBean.setHibernateProperties(hibernateProps);
    localSessionFactoryBean.setPackagesToScan("com.jamie.yozu.domain");
    localSessionFactoryBean.setAnnotatedPackages("com.jamie.yozu.domain");
    localSessionFactoryBean.afterPropertiesSet();
    return localSessionFactoryBean.getObject();
  } 

  @Override
  public TransactionManager annotationDrivenTransactionManager() {
    try {
      return transactionManager();
    } catch (IOException ex) {
      throw new FailedToStartExeception("Failed to setup Datasource", ex);
    }
  }

}