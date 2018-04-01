package org.com.framework.service;

import java.util.List;

import org.com.framework.bean.SysUser;

public interface ISysUserService {

	List<SysUser> findUser(SysUser user);

	void saveUser(SysUser user);

	void deleteUser(String ids);
	
	long findUserCount(SysUser user);

	SysUser getUserById(Integer id) throws Exception;

	SysUser getUserByAccount(String account);
}
