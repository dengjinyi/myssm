package org.com.framework.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.com.framework.bean.SysRole;
import org.com.framework.service.ISysRoleService;
import org.com.framework.system.mapper.SysRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("roleService")
@Scope("prototype")
public class SysRoleServiceImpl implements ISysRoleService {

	@Autowired
	private SysRoleMapper roleMapper;
	
	@Override
	public List<SysRole> findRole(SysRole role) {
		return roleMapper.findRole(role);
	}

	@Override
	public void saveRole(SysRole role) {
		if(!StringUtils.isEmpty(role.getId())){
			roleMapper.updateRole(role);
		}else{
			roleMapper.insertRole(role);
		}
	}

	@Override
	public void deleteRole(String ids) {
		if(!StringUtils.isEmpty(ids)){
			String[] array = ids.split(",");
			List<Integer> list = new ArrayList<Integer>();
			for(String id : array){
				list.add(Integer.valueOf(id));
			}
			roleMapper.deleteRole(list);		
		}
	}
	
	public long findRoleCount(SysRole role){
		return roleMapper.findRoleCount(role);
	}

	@Override
	public SysRole getRoleById(Integer id) {
		return roleMapper.getRoleById(id);
	}
	

}
