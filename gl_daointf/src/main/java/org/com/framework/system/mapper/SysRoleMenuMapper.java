package org.com.framework.system.mapper;

import java.util.List;

import org.com.framework.bean.SysRoleMenu;

public interface SysRoleMenuMapper {

	/**
	 * 查询用户角色关系表数据
	 * @param userRole
	 * */
	List<SysRoleMenu> findRoleMenu(SysRoleMenu roleMenu);
	
	/**
	 * 删除用户角色表关联数据
	 * @param userRole
	 * */
	void deleteRoleMenu(SysRoleMenu roleMenu);
	
	/**
	 * 保存用户角色的关联关系
	 * @param userRole 用户角色
	 * */
	Integer insert(SysRoleMenu roleMenu);
}
