package org.com.framework.service;

import java.util.List;

import org.com.framework.bean.SysOrg;


public interface ISysOrgService {

	/**
	 * 查询
	 * @param org 机构
	 * */
	List<SysOrg> findList(SysOrg org);

	/**
	 * 保存或修改
	 * @param org 机构
	 * */
	void saveOrUpdate(SysOrg org);

	/**
	 * 删除
	 * @param ids 一个或多个id
	 * */
	void delete(String ids);
	
	/**
	 * 按条件统计查询
	 * @param org机构
	 * */
	long findCount(SysOrg org);

	/**
	 * 按Id查询
	 * @param id
	 * */
	SysOrg getById(Integer id);
}
