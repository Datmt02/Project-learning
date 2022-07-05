package su22b1_it16304_sof3021.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import su22b1_it16304_sof3021.interceptors.BuyInterceptors;
import su22b1_it16304_sof3021.interceptors.DemoLogInterceptors;

@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer{

	@Autowired
	DemoLogInterceptors interceptors;
	@Autowired
	BuyInterceptors buyInterceptors;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(interceptors).addPathPatterns("/admin/**");
		registry.addInterceptor(buyInterceptors).addPathPatterns("/action/**");
	}

}
