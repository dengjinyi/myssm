/*
 * @# PaginationInterceptor.java Jul 30, 2012 2:12:38 PM
 * 
 * Copyright (C) 2011 - 2012 希世网络
 * XiShi information technology co. ltd.
 * 
 * All rights reserved!
 
package org.com.framework.mybatis.interceptor;

import java.sql.Connection;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.RowBounds;
import org.com.framework.orm.Dialect;
import org.com.framework.orm.DialectFactory;



 * @author dengjinyi
 * 分页拦截器
 * 按不同的数据库类型对查询进行分页构造查询
 
@Intercepts( { @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class }) })
public class PaginationInterceptor implements Interceptor {

	private final static Log log = LogFactory.getLog(PaginationInterceptor.class);
	private static final ObjectFactory DEFAULT_OBJECT_FACTORY = new DefaultObjectFactory();
    private static final ObjectWrapperFactory DEFAULT_OBJECT_WRAPPER_FACTORY = new DefaultObjectWrapperFactory();
    
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
		BoundSql boundSql = statementHandler.getBoundSql();
		MetaObject metaStatementHandler = MetaObject.forObject(statementHandler,  
				DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY);  
		RowBounds rowBounds = (RowBounds) metaStatementHandler.getValue("delegate.rowBounds");
		if (rowBounds == null || rowBounds == RowBounds.DEFAULT) {
			return invocation.proceed();
		}
		Configuration configuration = (Configuration) metaStatementHandler.getValue("delegate.configuration");
		String databaseType = null;
		try {
			databaseType = configuration.getVariables().getProperty("dialect").toUpperCase();
		} catch (Exception e) {
			// ignore  
		}

		if (databaseType == null) {
			throw new RuntimeException("the value of the dialect property in configuration.xml is not defined : "
					+ configuration.getVariables().getProperty("dialect"));
		}
		Dialect dialect = DialectFactory.getDialect(databaseType);
		if (rowBounds.getLimit() > 0 && rowBounds.getLimit() < RowBounds.NO_ROW_LIMIT) {
			String originalSql = (String) metaStatementHandler.getValue("delegate.boundSql.sql");
			metaStatementHandler.setValue("delegate.boundSql.sql", dialect.getPaginationSql(originalSql, rowBounds
					.getOffset(), rowBounds.getLimit()));
			metaStatementHandler.setValue("delegate.rowBounds.offset", RowBounds.NO_ROW_OFFSET);
			metaStatementHandler.setValue("delegate.rowBounds.limit", RowBounds.NO_ROW_LIMIT);
			if (log.isDebugEnabled()) {
				log.debug("生成分页SQL : " + boundSql.getSql().replaceAll("(?m)\\s*$", ""));
			}
		}
		return invocation.proceed();
	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties arg0) {

	}

}
*/