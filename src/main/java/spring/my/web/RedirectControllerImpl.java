package spring.my.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RedirectControllerImpl implements RedirectController{

	@Override
	@RequestMapping(value = "/place.slp", method = RequestMethod.GET)
	public String addRedirect() {
		return "thunder";
	}
}
