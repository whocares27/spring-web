package rewards;

// TODO 00: Run the web-app and see that it is working

// TODO 05: Create a WebAppInitializer
// Uncomment the code below.
// Make the necessary imports (Ctrl+Shift+O in Eclipse STS).
public class RewardsOnlineWebAppInitializer
		/* extends AbstractAnnotationConfigDispatcherServletInitializer */ {

	/*
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { RewardsConfig.class, SecurityConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { RewardsOnlineConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		super.onStartup(servletContext);
		DelegatingFilterProxy delegatingFilterProxy = new DelegatingFilterProxy();
		servletContext.addFilter(
				"springSecurityFilterChain", delegatingFilterProxy)
			.addMappingForUrlPatterns(null, false, "/*");
	}
	*/

}
