package tn.esprit.spring;

import java.io.File;
import java.util.EnumSet;
import java.util.TimeZone;

import javax.annotation.PostConstruct;
import javax.faces.webapp.FacesServlet;
import javax.servlet.DispatcherType;

import org.ocpsoft.rewrite.servlet.RewriteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

import tn.esprit.spring.config.LoginFilter;



@SpringBootApplication
@EntityScan(basePackageClasses = {
		DariApplication.class,
		Jsr310JpaConverters.class
})
public class DariApplication  {

	public void addViewControllers(ViewControllerRegistry registry) {
		//registry.addViewController("/welcome").setViewName("welcome");
		//registry.addViewController("/home").setViewName("home");
	}
	@PostConstruct
	void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}
	public static void main(String[] args) throws Exception {
		//new File(FileUploadController.uploadDirectory).mkdir();//
		SpringApplication.run(DariApplication.class, args);

	}
	
	@Bean
	public ServletRegistrationBean servletRegistrationBean() {
		FacesServlet servlet = new FacesServlet();
		return new ServletRegistrationBean(servlet, "*.jsf"); }
	@Bean
	public FilterRegistrationBean rewriteFilter() {
		FilterRegistrationBean rwFilter = new FilterRegistrationBean(new RewriteFilter());
		rwFilter.setDispatcherTypes(EnumSet.of(DispatcherType.FORWARD, DispatcherType.REQUEST,DispatcherType.ASYNC, DispatcherType.ERROR));
		rwFilter.addUrlPatterns("/*");
		return rwFilter;
	}
	@Bean
	public FilterRegistrationBean loginFilter() {
	FilterRegistrationBean registration = new FilterRegistrationBean();
	registration.setFilter(new LoginFilter());
	registration.addUrlPatterns("/pages/*");
	return registration;
	}
}