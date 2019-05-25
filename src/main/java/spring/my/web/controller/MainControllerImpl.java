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

	/* 장소추가 페이지 */
	@Override
	@RequestMapping(value = "/place.slp", method = RequestMethod.GET)
	public ModelAndView placeRedirect() {
		ModelAndView mv = new ModelAndView();
		ArrayList<UserVO> aList = ms.selectAllUser();
		mv.addObject("user", aList);
		mv.setViewName("place");
		return mv;
	}

	/* 참여자추가 페이지 */
	@Override
	@RequestMapping(value = "/add.slp", method = RequestMethod.GET)
	public ModelAndView addRedirect() {
		ArrayList<CityVO> alist = ms.getAddress();
		ModelAndView mv = new ModelAndView();
		mv.addObject("city", alist);
		mv.setViewName("add");
		return mv;
	}

	/* 장소추가 확인 */
	@Override
	@RequestMapping(value = "/placesave.slp", method = RequestMethod.POST)
	public ModelAndView placesave(@RequestParam String location, @RequestParam String address,
			@RequestParam String password, @RequestParam String[] userInfo, @RequestParam String rdate,
			@RequestParam String hour, @RequestParam String minute) {

		ModelAndView mv = new ModelAndView();

		if (!password.equals("0519")) {
			mv.setViewName("pwderr");
			return mv;
		} else {
			ArrayList<UserVO> aList = new ArrayList<UserVO>();
			for (String s : userInfo) {
				UserVO uv = new UserVO();
				String[] tempInfo = s.split("/");
				uv.setUserName(tempInfo[0]);
				uv.setUserGender(tempInfo[1]);
				uv.setUserAddr(tempInfo[2]);
				uv.setUserAge(Integer.parseInt(tempInfo[3]));
				aList.add(uv);
			}
			placeVO pv = new placeVO();
			pv.setLocation(location);
			pv.setAddress(address);
			mv.addObject("place", pv);
			mv.addObject("user", aList);
			mv.addObject("rdate", rdate);
			mv.addObject("hour", hour);
			mv.addObject("minute", minute);
			mv.setViewName("chkplace");
			return mv;
		}
	}

	/* 장소추가 저장 */
	@Override
	@RequestMapping(value = "/placeprocess.slp", method = RequestMethod.POST)
	public String placeprocess(@RequestParam String location, @RequestParam String address,
			@RequestParam(required = false) String userInfo, @RequestParam String rdate, @RequestParam String hour,
			@RequestParam String minute) {

		// String insertDate = Utils.getInsertNumber();

		// System.out.println(insertDate);
		// System.out.println(location);
		// System.out.println(address);
		// System.out.println(rdate);
		// System.out.println(hour);
		// System.out.println(minute);
		// String[] userInfoSplit = userInfo.split(",");
		// for (String s : userInfoSplit) {
		// System.out.println(s);
		// }
		return "redirect:/";
	}

	/* 참여자추가 저장 */
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
