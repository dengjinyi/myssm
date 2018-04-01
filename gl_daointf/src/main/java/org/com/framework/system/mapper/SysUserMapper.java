package org.com.framework.system.mapper;

import java.util.List;

import org.com.framework.bean.SysUser;

public interface SysUserMapper extends BaseMapper<SysUser>{

	/*List<SysUser> findByPage(SysUser user);
	
	void insertUser(SysUser user);

	void deleteUser(List<Integer> ids);
	
	long findUserCount(SysUser user);

	SysUser getUserById(Integer id);

	void updateUser(SysUser user);*/
	
	/**
	 * 根据账号查询
	 * @param account
	 * */
	SysUser findByAccount(String account);
}
