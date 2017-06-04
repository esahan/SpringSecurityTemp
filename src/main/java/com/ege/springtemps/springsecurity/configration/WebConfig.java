package com.ege.springtemps.springsecurity.configration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.ege.springtemps.springsecurity.converter.RoleToUserProfileConverter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.ege.springtemps.springsecurity.web" })
public class WebConfig extends WebMvcConfigurerAdapter{
	
	@Autowired
    RoleToUserProfileConverter roleToUserProfileConverter;
	
	@Bean
	public ViewResolver viewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setSuffix(".jsp");
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setExposeContextBeansAsAttributes(true);
		return resolver;
	}
	
		// WebConfig class extends WebMvcConfigurerAdapter and overrides
		// its configureDefaultServletHandling() method. By calling enable() on the
		// given
		// DefaultServletHandlerConfigurer, you�re asking DispatcherServlet to
		// forward
		// requests for static resources to the servlet container�s default servlet
		// and not to try to
		// handle them itself.
		@Override
		public void configureDefaultServletHandling(
				DefaultServletHandlerConfigurer configurer) {
			configurer.enable();
		}

		// It loads messages from a properties file whose name is derived
		// from a base name. The following @Bean method configures
		// ResourceBundleMessage
		// <h1><s:message code="ege.welcome" /></h1>
		@Bean
		public MessageSource messageSource() {
			ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
			messageSource.setBasename("messages");
			return messageSource;
		}
		
	    
	     // Configure ResourceHandlers to serve static resources like CSS/ Javascript etc...
	     
		@Override
		public void addResourceHandlers(final ResourceHandlerRegistry registry) {
			registry.addResourceHandler("/resources/**")
					.addResourceLocations("/resources/");
		}
	
	    
//	      Configure Converter to be used.
//	      We need a converter to convert string values[Roles] to UserProfiles in newUser.jsp	     
	    @Override
	    public void addFormatters(FormatterRegistry registry) {
	        registry.addConverter(roleToUserProfileConverter);
	    }
}
