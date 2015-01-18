package com.paxovision.cucumber.framework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource(value = {
        "classpath:properties/${envTarget}.webdriver.properties"
})
public class SpringTestPropertyConfig {
	@Bean
    public PropertySourcesPlaceholderConfigurer getProperties() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}


//"classpath:properties/app-${spring.profiles.active:default}.properties"
//"classpath:properties/qa1.properties"