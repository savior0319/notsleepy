package spring.my.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Util클래스
 * 
 * @author AHJ
 * @Date 2019-05-25
 **/
@SuppressWarnings("all")
public class Utils {

	private static Utils utils;

	private Utils() {
	};

	/**
	 * String PK용 랜덤 값 생성(년월일-랜덤6자리 생성)
	 * 
	 * @author AHJ
	 * @param isnull
	 * @return String
	 * @Date 2019-05-25
	 **/
	public static String getInsertNumber() {

		UUID uid = UUID.randomUUID();
		String[] uidSplit = uid.toString().split("-");

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss-");
		String insertDate = sdf.format(date);
		insertDate += uidSplit[0];

		return insertDate;
	}

}
