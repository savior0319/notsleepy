package spring.my.web.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import spring.my.web.vo.CityVO;
import spring.my.web.vo.UserVO;

@SuppressWarnings("all")
@Repository(value = "MainDAO")
public class MainDAOImpl implements MainDAO {

	public MainDAOImpl() {
	}

	@Override
	public ArrayList<CityVO> selectAddress(SqlSessionTemplate session) {
		List<?> list = session.selectList("main.selectAddress");
		return (ArrayList<CityVO>) list;
	}

	@Override
	public int insertUser(SqlSessionTemplate session, UserVO uv) {
		return session.insert("main.insertUser", uv);
	}

	@Override
	public ArrayList<UserVO> selectAllUser(SqlSessionTemplate session) {
		List<?> list = session.selectList("main.selectAllUser");
		return (ArrayList<UserVO>) list;
	}

}
