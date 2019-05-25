package spring.my.web.controller;

import org.springframework.web.servlet.ModelAndView;

import spring.my.web.vo.UserVO;

public interface MainController {

	public ModelAndView addRedirect();

	public ModelAndView addprocess(String pwd, UserVO uv);

	public ModelAndView placeRedirect();

	public ModelAndView placesave(String location, String address, String password, String[] userInfo);
}
