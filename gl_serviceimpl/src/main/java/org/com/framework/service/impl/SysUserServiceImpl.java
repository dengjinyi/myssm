package org.com.framework.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.com.framework.bean.SysUser;
import org.com.framework.common.AppConfig;
import org.com.framework.common.CryptUtil;
import org.com.framework.service.ISysUserService;
import org.com.framework.system.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("userService")
@Scope("prototype")
public class SysUserServiceImpl implements ISysUserService {

	@Autowired
	private SysUserMapper userMapper;
	
	@Override
	public List<SysUser> findUser(SysUser user) {
		return userMapper.findByPage(user);
	}

	@Override
	public void saveUser(SysUser user) {
		user.setPassword(CryptUtil.encrypt(user.getPassword(),AppConfig.key));
		if(!StringUtils.isEmpty(user.getId())){
			userMapper.update(user);
		}else{
			userMapper.save(user);
		}
	}

	@Override
	public void deleteUser(String ids) {
		if(!StringUtils.isEmpty(ids)){
			String[] array = ids.split(",");
			List<Integer> list = new ArrayList<Integer>();
			for(String id : array){
				list.add(Integer.valueOf(id));
			}
			userMapper.deleteByIds(list);		
		}
	}
	
	public long findUserCount(SysUser user){
		return userMapper.findCount(user);
	}

	@Override
	public SysUser getUserById(Integer id) throws Exception{
		SysUser user = userMapper.getById(id);
		user.setPassword(CryptUtil.decrypt(user.getPassword(), AppConfig.key));
		return user;
	}

	@Override
	public SysUser getUserByAccount(String account) {
		return userMapper.findByAccount(account);
	}

}
