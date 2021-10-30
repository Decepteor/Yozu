package com.jamie.yozu.configuration;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import freemarker.cache.ConditionalTemplateConfigurationFactory;
import freemarker.cache.FileExtensionMatcher;
import freemarker.cache.TemplateConfigurationFactory;
import freemarker.core.HTMLOutputFormat;
import freemarker.core.TemplateConfiguration;
import freemarker.template.TemplateException;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.jamie.yozu"})
public class FrontendConfiguration implements WebMvcConfigurer {
  
  @Autowired
  private ServletContext context;

  @Bean
  public FreeMarkerConfigurer freemarkerConfigurer() throws IOException, TemplateException {
    Properties settings = new Properties();
    settings.put("default_encoding", "UTF-8");
    FreeMarkerConfigurer freemarkerConfig = new FreeMarkerConfigurer();
    Map<String, Object> globalModel = new HashMap<>();
    globalModel.put("context", context.getContextPath());
    freemarkerConfig.setFreemarkerVariables(globalModel);
    freemarkerConfig.setFreemarkerSettings(settings);
    freemarkerConfig.setTemplateLoaderPath("classpath:/templates");
    freemarkerConfig.afterPropertiesSet();
    TemplateConfiguration templateConfiguration = new TemplateConfiguration();
    templateConfiguration.setOutputFormat(HTMLOutputFormat.INSTANCE);
    TemplateConfigurationFactory factory = new ConditionalTemplateConfigurationFactory(new FileExtensionMatcher("ftl"), 
                                                                                           templateConfiguration);
    freemarkerConfig.getConfiguration().setTemplateConfigurations(factory);
    return freemarkerConfig;
  }
  
  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addRedirectViewController("/", "home");
  }
  
}
