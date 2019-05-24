package spring.my.web.service;

import java.util.ArrayList;

import spring.my.web.vo.CityVO;
import spring.my.web.vo.UserVO;

public interface MainService {

	public ArrayList<CityVO> getAddress();

	public int insertUser(UserVO uv);

}
