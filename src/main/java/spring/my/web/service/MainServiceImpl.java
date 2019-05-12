package spring.my.web.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.my.web.dao.MainDAO;
import spring.my.web.vo.CityVO;

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

}
