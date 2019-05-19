package spring.my.web.controller;

import org.springframework.web.servlet.ModelAndView;

public interface MainController {

	public ModelAndView addRedirect();

	public ModelAndView placesave(String location, String address, String password);
}
