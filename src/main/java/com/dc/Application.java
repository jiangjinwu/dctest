package com.dc;


import org.codehaus.groovy.tools.shell.util.MessageSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

//@SpringBootApplication(/*exclude=org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration.class*/)
@SpringBootApplication
/*@ComponentScan(basePackages={"com.dc"}) 
@EntityScan(basePackages={"com.dc"})
@EnableJpaRepositories(basePackages={"com.dc"})*/
/*@EnableAutoConfiguration
@Configuration*/
/*@Import({
        DispatcherServletAutoConfiguration.class,
        EmbeddedServletContainerAutoConfiguration.class,
        ErrorMvcAutoConfiguration.class,
        HttpEncodingAutoConfiguration.class,
        HttpMessageConvertersAutoConfiguration.class,
        JacksonAutoConfiguration.class,
        JmxAutoConfiguration.class,
        MultipartAutoConfiguration.class,
        ServerPropertiesAutoConfiguration.class,
        PropertyPlaceholderAutoConfiguration.class,
        ThymeleafAutoConfiguration.class,
        WebMvcAutoConfiguration.class,
        WebSocketAutoConfiguration.class,
        
        JpaRepositoriesAutoConfiguration.class
})*/
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}
	
	  /*@Bean(name = "messageSource")
	    public MessageSource messageSource() {
	        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
	        //messageSource.setBasename(MESSAGE_SOURCE);
	        messageSource.setCacheSeconds(5);
	        return messageSource;
	    }*/
}
