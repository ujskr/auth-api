package com.proj.auth.util;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.proj.entity.quiz.UserAddress;

public class AuthUtil {
	public static Date formatDate(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD");
		dateFormat.format(date);
		return date;
	}
	public static UserAddress setAddress(String str) {
		UserAddress userAddress = new UserAddress();
		userAddress.setAddressId(str);
		return userAddress;
	}
}
