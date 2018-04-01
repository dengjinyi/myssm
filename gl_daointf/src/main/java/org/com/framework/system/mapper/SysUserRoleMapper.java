package org.com.framework.system.mapper;

import java.util.List;

import org.com.framework.bean.SysUserRole;

public interface SysUserRoleMapper {

	/**
	 * 查询用户角色关系表数据
	 * @param userRole
	 * */
	List<SysUserRole> findUserRole(SysUserRole userRole);
	
	/**
	 * 删除用户角色表关联数据
	 * @param userRole
	 * */
	void deleteUserRole(SysUserRole userRole);
	
	/**
	 * 保存用户角色的关联关系
	 * @param userRole 用户角色
	 * */
	Integer insertUserRole(SysUserRole userRole);
	
	
}
