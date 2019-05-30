package spring.my.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RedirectControllerImpl implements RedirectController {

	@Override
	@RequestMapping(value = "/reservegrantchk.slp")
	public ModelAndView reservechk() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("reservegrantchk");
		return mv;
	}

}
