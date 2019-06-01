package spring.my.web.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.my.web.dao.MainDAO;
import spring.my.web.vo.CityVO;
import spring.my.web.vo.ReserveDtVO;
import spring.my.web.vo.ReserveVO;
import spring.my.web.vo.UserVO;

@Service(value = "MainService")
public class MainServiceImpl implements MainService {

	public MainServiceImpl() {
	}

	@Autowired
	private SqlSessionTemplate session;

	@Resource(name = "MainDAO")
	private MainDAO md;

	@Override
	public ArrayList<CityVO> getAddress() {
		return md.selectAddress(session);
	}

	@Override
	public int insertUser(UserVO uv) {
		return md.insertUser(session, uv);
	}

	@Override
	public ArrayList<UserVO> selectAllUser() {
		return md.selectAllUser(session);
	}

	@Override
	public int saveReserve(ReserveVO rv) {
		return md.saveReserve(session, rv);
	}

	@Override
	public int saveReserveDt(ReserveDtVO rDt) {
		return md.saveReserveDt(session, rDt);
	}

	@Override
	public ArrayList<ReserveVO> selectReserve() {
		return md.selectReserve(session);
	}

}
