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
import spring.my.web.vo.PlaceVO;
import spring.my.web.vo.ReserveDtVO;
import spring.my.web.vo.ReserveVO;
import spring.my.web.vo.UserVO;

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
				uv.setUserSeq(tempInfo[4]);
				aList.add(uv);
			}
			PlaceVO pv = new PlaceVO();
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
	public ModelAndView placeprocess(@RequestParam String location, @RequestParam String address,
			@RequestParam(required = false) String userInfo, @RequestParam String rdate, @RequestParam String hour,
			@RequestParam String minute) {

		// 장소저장번호 생성
		String rNo = Utils.getInsertNumber();

		String[] rdateYSplit = rdate.split("년");
		String[] rdateMSplit = rdateYSplit[1].split("월");
		String[] rdateDSplit = rdateMSplit[1].split("일");
		String rdateYMD = rdateYSplit[0].replace(" ", "") + "-" + rdateMSplit[0].replace(" ", "") + "-"
				+ rdateDSplit[0].replace(" ", "");
		String hourMin = hour + ":" + minute;
		String[] userInfoSplit = userInfo.split(",");

		// 장소정보 저장 (RESERVE)
		ReserveVO rv = new ReserveVO();
		rv.setRNo(rNo);
		rv.setLocation(location);
		rv.setAddress(address);
		rv.setrDate(rdateYMD + " " + hourMin);

		int rResult = ms.saveReserve(rv);

		// 사용자 시퀀스 정보가져와서 저장 (RESERVEDT)
		String[] userSplit = new String[4];
		int rDtResult = 0;

		for (String s : userInfoSplit) {
			ReserveDtVO rDt = new ReserveDtVO();
			userSplit = s.split("/");
			rDt.setRNo(rNo);
			rDt.setUserSeq(userSplit[4]);

			rResult = ms.saveReserveDt(rDt);
		}

		ModelAndView mv = new ModelAndView();
		if (rResult < 0 || rDtResult < 0) {
			mv.addObject("rNo", rNo);
			mv.setViewName("placeprocessfail");
			return mv;
		}

		mv.addObject("rNo", rNo);
		mv.setViewName("placeprocesschk");
		return mv;
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

	/* 장소확인 비밀번호 체크 */
	@Override
	@RequestMapping(value = "/reservepwdchk.slp", method = RequestMethod.POST)
	public ModelAndView reservepwdchk(@RequestParam String pwd) {
		
		ModelAndView mv = new ModelAndView();

		if (!pwd.equals("0519")) {
			mv.setViewName("pwderr");
			return mv;
		} else {
			mv.setViewName("redirect:/");
			return mv;
		}
	}

}
