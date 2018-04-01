package org.com.framework.service;

import java.util.List;

import org.com.framework.bean.SysRole;


public interface ISysRoleService {

	List<SysRole> findRole(SysRole role);

	void saveRole(SysRole role);

	void deleteRole(String ids);
	
	long findRoleCount(SysRole role);

	SysRole getRoleById(Integer id);
}
