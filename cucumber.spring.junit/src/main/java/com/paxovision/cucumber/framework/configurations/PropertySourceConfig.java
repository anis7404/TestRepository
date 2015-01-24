package com.paxovision.cucumber.framework.configurations;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.util.StringUtils;

@Configuration
@PropertySource(value = {
        "classpath:properties/${envTarget}.webdriver.properties"
})
public class PropertySourceConfig {


	
	@Bean
    public static PropertySourcesPlaceholderConfigurer getProperties() throws IOException {
		
		/*System.out.println("Hi there");
		String envTarget = System.getProperty("envTarget");
        if (!StringUtils.hasText(envTarget)) {
            envTarget = "default";
            System.setProperty("envTarget", envTarget);
        }
        
		PropertySourcesPlaceholderConfigurer propertyConfigurer = new PropertySourcesPlaceholderConfigurer();
	    propertyConfigurer.setLocations(new PathMatchingResourcePatternResolver().getResources("classpath:properties/" + envTarget + ".webdriver.properties"));
	    return propertyConfigurer;*/
        return new PropertySourcesPlaceholderConfigurer();
    }
	
}
