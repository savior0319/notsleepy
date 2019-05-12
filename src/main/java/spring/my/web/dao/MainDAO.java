package spring.my.web.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;

import spring.my.web.vo.CityVO;

public interface MainDAO {

	public ArrayList<CityVO> selectAddress(SqlSessionTemplate session);

}
