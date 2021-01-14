package tw.leonchen.config;

import java.util.List;

import javax.servlet.annotation.MultipartConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"tw.leonchen"})
public class SpringMVCJavaConfig implements WebMvcConfigurer{

	
	
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	@Bean	
	public InternalResourceViewResolver viewResolver(){
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/pages/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setOrder(2);
		return viewResolver;
	}
	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver  MultipartResolver() {
		CommonsMultipartResolver com = new CommonsMultipartResolver();
		com.setDefaultEncoding("UTF-8");
		return com;
	}
	@Bean
	public MappingJackson2JsonView jsonview() {
		MappingJackson2JsonView json = new MappingJackson2JsonView();
		json.setPrettyPrint(true);
		return json;
		
	}
	
	
	
	
	
//	public Jaxb2Marshaller jaxb2() {
//		Jaxb2Marshaller jaxb = new Jaxb2Marshaller();
//	
//		return jaxb;
//		
//	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/images/**")
		      .addResourceLocations("/WEB-INF/resources/images/");
	}
	

	
	
	

	
}
