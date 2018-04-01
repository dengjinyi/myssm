package org.com.framework.system.mapper;

import java.util.List;

import org.com.framework.bean.SysMenu;

public interface SysMenuMapper extends BaseMapper<SysMenu>{

	/*List<SysMenu> findByPage(SysMenu menu);
	
	List<SysMenu> findList(SysMenu menu);
	
	
	void insertMenu(SysMenu menu);

	void deleteMenu(List<Integer> ids);
	
	long findMenuCount(SysMenu menu);
	
	SysMenu getMenuById(Integer id);

	void updateMenu(SysMenu menu);*/

	long findByPids(List<Integer> list);
}
