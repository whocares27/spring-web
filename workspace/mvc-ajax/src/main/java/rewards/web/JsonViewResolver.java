package rewards.web;


import java.util.Locale;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

public class JsonViewResolver implements ViewResolver {
@Override
	public View resolveViewName(String viewName, Locale locale) {
	return new MappingJackson2JsonView();
	}


}