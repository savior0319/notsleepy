package spring.my.web.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;

import spring.my.web.vo.CityVO;
import spring.my.web.vo.UserVO;

public interface MainDAO {

	public ArrayList<CityVO> selectAddress(SqlSessionTemplate session);

	public int insertUser(SqlSessionTemplate session, UserVO uv);

	public ArrayList<UserVO> selectAllUser(SqlSessionTemplate session);

}
