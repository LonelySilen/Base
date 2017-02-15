package com.silen.util;

import java.util.Date;

public class GetDate {

	public Date getSqlDate() {
		Date sqlDate = new java.sql.Date(new Date().getTime());
		return sqlDate;
	}

}
