package org.com.framework.service;

import java.util.List;

import org.com.framework.bean.SysParam;
import org.com.framework.model.PageModel;

public interface ISysParamService {

	/**
	 * 分页查询
	 * */
	PageModel<SysParam> findByPage(SysParam param,int pageNumber,int pageSize);
	
	/**
	 * 按条件查询不分页
	 * */
	List<SysParam> findList(SysParam param);

	/**
	 * 保存或修改
	 * */
	int saveOrUpdate(SysParam param);

	/**
	 * 按ID删除
	 * */
	void deleteById(Integer id);
	
	/**
	 * 按条件查询总数
	 * */
	int findCount(SysParam param);

	/**
	 * 按ID单条查询
	 * */
	SysParam getById(Integer id);
}
