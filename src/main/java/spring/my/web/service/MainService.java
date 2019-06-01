package spring.my.web.service;

import java.util.ArrayList;

import spring.my.web.vo.CityVO;
import spring.my.web.vo.ReserveDtVO;
import spring.my.web.vo.ReserveVO;
import spring.my.web.vo.UserVO;

public interface MainService {

	public ArrayList<CityVO> getAddress();

	public int insertUser(UserVO uv);

	public ArrayList<UserVO> selectAllUser();

	public int saveReserve(ReserveVO rv);

	public int saveReserveDt(ReserveDtVO rDt);

	public ArrayList<ReserveVO> selectReserve();

}
