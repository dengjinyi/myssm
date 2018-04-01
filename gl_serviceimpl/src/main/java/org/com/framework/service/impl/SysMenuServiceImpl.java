package org.com.framework.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.com.framework.bean.SysMenu;
import org.com.framework.service.ISysMenuService;
import org.com.framework.system.mapper.SysMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("menuService")
@Scope("prototype")
public class SysMenuServiceImpl implements ISysMenuService {

	@Autowired
	private SysMenuMapper menuMapper;
	
	@Override
	public List<SysMenu> findByPage(SysMenu menu) {
		return menuMapper.findByPage(menu);
	}

	@Override
	public void saveMenu(SysMenu menu) {
		if(!StringUtils.isEmpty(menu.getId())){
			menuMapper.update(menu);
		}else{
			menuMapper.save(menu);
		}
	}

	@Override
	public void deleteMenu(String ids) {
		if(!StringUtils.isEmpty(ids)){
			String[] array = ids.split(",");
			List<Integer> list = new ArrayList<Integer>();
			for(String id : array){
				list.add(Integer.valueOf(id));
			}
			menuMapper.deleteByIds(list);		
		}
	}
	
	public long findMenuCount(SysMenu menu){
		return menuMapper.findCount(menu);
	}

	@Override
	public SysMenu getMenuById(Integer id) {
		return menuMapper.getById(id);
	}
	
	@Override
	public List<SysMenu> findMenuTree(SysMenu menu){
		return menuMapper.findList(menu);
	}

	@Override
	public boolean checkChildren(String ids) {
		if(!StringUtils.isEmpty(ids)){
			String[] array = ids.split(",");
			List<Integer> list = new ArrayList<Integer>();
			for(String id : array){
				list.add(Integer.valueOf(id));
			}
			long total = menuMapper.findByPids(list);
			if(total > 0){
				return true;
			}
		}
		return false;
	}
	

}
