package spring.my.web.controller;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import spring.my.web.service.MainService;
import spring.my.web.vo.CityVO;

@Controller
public class MainControllerImpl implements MainController {

	public MainControllerImpl() {
	}

	@Resource(name = "MainService")
	private MainService ms;

	@Override
	@RequestMapping(value = "/add.slp", method = RequestMethod.GET)
	public ModelAndView addRedirect() {
		ArrayList<CityVO> alist = ms.getAddress();
		ModelAndView mv = new ModelAndView();
		mv.addObject("city", alist);
		mv.setViewName("add");
		return mv;
	}
}
