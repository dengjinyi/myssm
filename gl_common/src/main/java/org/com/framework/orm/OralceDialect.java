/*
 * @# PaginationInterceptor.java Jul 30, 2012 2:12:38 PM
 * 
 * Copyright (C) 2011 - 2012 希世网络
 * XiShi information technology co. ltd.
 * 
 * All rights reserved!
 */
package org.com.framework.orm;

/**
 * Oracle数据库的分页实现.
 * 
 * @author alvin hwang
 */
public class OralceDialect implements Dialect {

	@Override
	public boolean isPaginationSupportable() {
		return true;
	}

	@Override
	public String getPaginationSql(String sql, int offset, int limit) {
		if (offset < 0 || limit <= 0) {
			return sql;
		}
		String trimmedSql = sql.trim();
		StringBuffer sb = new StringBuffer(trimmedSql.length() + 80);
		sb.append("SELECT * FROM (SELECT A.*, ROWNUM RN FROM (").append(trimmedSql).append(") A WHERE ROWNUM <= ")
				.append(offset + limit).append(") WHERE RN > ").append(offset);
		return sb.toString();
	}

	@Override
	public String getCountSql(String sql) {
		return "select count(*) from (" + sql + ")";
	}
}
