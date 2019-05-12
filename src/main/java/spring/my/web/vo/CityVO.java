package spring.my.web.vo;

import java.sql.Timestamp;

public class CityVO {

	private int citySeq;
	private String cityFirstSection, citySecondSection, insertUser, cityCode;
	private Timestamp insertDate;

	public CityVO() {
	}

	public int getCitySeq() {
		return citySeq;
	}

	public void setCitySeq(int citySeq) {
		this.citySeq = citySeq;
	}

	public String getCityFirstSection() {
		return cityFirstSection;
	}

	public void setCityFirstSection(String cityFirstSection) {
		this.cityFirstSection = cityFirstSection;
	}

	public String getCitySecondSection() {
		return citySecondSection;
	}

	public void setCitySecondSection(String citySecondSection) {
		this.citySecondSection = citySecondSection;
	}

	public String getInsertUser() {
		return insertUser;
	}

	public void setInsertUser(String insertUser) {
		this.insertUser = insertUser;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public Timestamp getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Timestamp insertDate) {
		this.insertDate = insertDate;
	}

}
