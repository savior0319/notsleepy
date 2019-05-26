package spring.my.web.vo;

import java.sql.Timestamp;

public class ReserveDtVO {

	private String rNo, userSeq, deleteYn, insertUser;
	private Timestamp insertDate;

	public String getRNo() {
		return rNo;
	}

	public void setRNo(String rNo) {
		this.rNo = rNo;
	}

	public String getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(String userSeq) {
		this.userSeq = userSeq;
	}

	public String getDeleteYn() {
		return deleteYn;
	}

	public void setDeleteYn(String deleteYn) {
		this.deleteYn = deleteYn;
	}

	public String getInsertUser() {
		return insertUser;
	}

	public void setInsertUser(String insertUser) {
		this.insertUser = insertUser;
	}

	public Timestamp getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Timestamp insertDate) {
		this.insertDate = insertDate;
	}

}
