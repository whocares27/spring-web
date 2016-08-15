package rewards.web;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ThemeResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.theme.CookieThemeResolver;
import org.springframework.web.servlet.theme.ThemeChangeInterceptor;

// TODO 02: Customize Spring Boot auto-configuration for Web/MVC
/*
 * If you want to keep Spring Boot MVC features, and you just want to add
 * additional MVC configuration (interceptors, formatters, view controllers
 * etc.) you can add your own @Bean of type WebMvcConfigurerAdapter, but
 * _without_ @EnableWebMvc.
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	// TODO 02a: Configure "/" as a view controller (use "index.jsp" as view)

	// TODO 02b: Configure Spring Boot's InternalResourceViewResolver
	/*
	 * Spring Boot provides a default InternalResourceViewResolver
	 * that looks at the following properties:
	 * - spring.view.prefix
	 * - spring.view.suffix
	 * 
	 * Go to the application.properties and modify the above properties.
	 * Make them point to where your JSP views are located.
	 */

	// TODO 02c: Configure Apache Tiles
	// Hint: This will require two (2) beans: a configurer, and a view resolver

	// TODO 02d: Serve static files (e.g. images) from /images and /styles
	/*
	 * Study WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter.
	 *
	 * By default Spring Boot will serve static content from a directory called
	 * /static (or /public or /resources or /META-INF/resources) in the
	 * classpath or from the root of the ServletContext.
	 *
	 * Either move the static files to the directory that Spring Boot expects,
	 * or modify "spring.resources.staticLocations" in application.properties,
	 * or configure additional resource handlers to serve static files from
	 * "/images" and "/styles".
	 */

	// TODO 02e: Configure a MessageSource for /WEB-INF/messages/global
	/*
	 * Study MessageSourceAutoConfiguration.
	 *
	 * By default Spring Boot will configure a MessageSource with a basename
	 * from the value of the "spring.messages.basename" property. By default,
	 * the value is "messages". This means it will look for messages.properties
	 * in the classpath.
	 * 
	 * Either move the files to the classpath and modify "spring.messages.basename",
	 * or configure your own message source bean.
	 */

	// TODO 03: Run this Spring Boot application to see if everything is configured properly

	@Bean
	public ThemeResolver themeResolver() {
		CookieThemeResolver themeResolver = new CookieThemeResolver();
		themeResolver.setDefaultThemeName("orange");
		return themeResolver;
	}

	@Bean
	public LocaleResolver localeResolver() {
		CookieLocaleResolver localeResolver = new CookieLocaleResolver();
		localeResolver.setDefaultLocale(Locale.ENGLISH);
		return localeResolver;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new ThemeChangeInterceptor());
		registry.addInterceptor(new LocaleChangeInterceptor());
	}
	
}
