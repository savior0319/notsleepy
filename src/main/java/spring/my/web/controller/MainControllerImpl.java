package spring.my.web.controller;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.my.web.service.MainService;
import spring.my.web.vo.CityVO;
import spring.my.web.vo.UserVO;
import spring.my.web.vo.placeVO;

@Controller
public class MainControllerImpl implements MainController {

	public MainControllerImpl() {
	}

	@Resource(name = "MainService")
	private MainService ms;

	/* 추가1 페이지 */
	@Override
	@RequestMapping(value = "/place.slp", method = RequestMethod.GET)
	public ModelAndView placeRedirect() {
		ModelAndView mv = new ModelAndView();
		ArrayList<UserVO> aList = ms.selectAllUser();
		mv.addObject("user", aList);
		mv.setViewName("place");
		return mv;
	}

	/* 추가2 페이지 */
	@Override
	@RequestMapping(value = "/add.slp", method = RequestMethod.GET)
	public ModelAndView addRedirect() {
		ArrayList<CityVO> alist = ms.getAddress();
		ModelAndView mv = new ModelAndView();
		mv.addObject("city", alist);
		mv.setViewName("add");
		return mv;
	}

	@Override
	@RequestMapping(value = "/placesave.slp", method = RequestMethod.POST)
	public ModelAndView placesave(@RequestParam String location, @RequestParam String address,
			@RequestParam String password) {

		ModelAndView mv = new ModelAndView();

		if (!password.equals("0519")) {
			mv.setViewName("pwderr");
			return mv;
		} else {
			placeVO pv = new placeVO();
			pv.setLocation(location);
			pv.setAddress(address);
			mv.addObject("place", pv);
			mv.setViewName("chkplace");
			return mv;
		}
	}

	@Override
	@RequestMapping(value = "/addprocess.slp", method = RequestMethod.POST)
	public ModelAndView addprocess(@RequestParam String password, @ModelAttribute UserVO uv) {

		ModelAndView mv = new ModelAndView();

		if (!password.equals("0519")) {
			mv.setViewName("pwderr");
			return mv;
		} else {
			int result = ms.insertUser(uv);
			if (result > 0) {
				mv.setViewName("savesuccess");
				return mv;
			} else {
				mv.setViewName("savefail");
				return mv;
			}
		}

	}

}
