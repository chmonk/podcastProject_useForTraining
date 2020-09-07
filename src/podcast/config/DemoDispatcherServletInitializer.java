package podcast.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//dispatcher servlet Spring auto get the instance of AbstractAnnotationConfigDispatcherServletInitializer
public class DemoDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter characterEncodingFilter=new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);
		return new Filter[] {characterEncodingFilter};
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
	
		return null;
	}

	@Override
	//for handler and resolver (instance of surface WebMvcConfigurer )
	protected Class<?>[] getServletConfigClasses() {
		
		return new Class[] {SpringMVCJavaConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		
		return new String[] {"/"};
	}

}
