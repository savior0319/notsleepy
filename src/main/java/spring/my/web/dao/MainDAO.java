package spring.my.web.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;

import spring.my.web.vo.CityVO;
import spring.my.web.vo.ReserveDtVO;
import spring.my.web.vo.ReserveVO;
import spring.my.web.vo.UserVO;

public interface MainDAO {

	public ArrayList<CityVO> selectAddress(SqlSessionTemplate session);

	public int insertUser(SqlSessionTemplate session, UserVO uv);

	public ArrayList<UserVO> selectAllUser(SqlSessionTemplate session);

	public int saveReserve(SqlSessionTemplate session, ReserveVO rv);

	public int saveReserveDt(SqlSessionTemplate session, ReserveDtVO rDt);

	public ArrayList<ReserveVO> selectReserve(SqlSessionTemplate session);

}
