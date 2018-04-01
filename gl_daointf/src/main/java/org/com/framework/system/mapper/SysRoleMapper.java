package org.com.framework.system.mapper;

import java.util.List;

import org.com.framework.bean.SysRole;

public interface SysRoleMapper {

	List<SysRole> findRole(SysRole Role);
	
	void insertRole(SysRole Role);

	void deleteRole(List<Integer> ids);
	
	long findRoleCount(SysRole Role);
	
	SysRole getRoleById(Integer id);
	
	void updateRole(SysRole role);
}
