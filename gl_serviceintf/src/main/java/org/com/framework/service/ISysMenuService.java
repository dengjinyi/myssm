package org.com.framework.service;

import java.util.List;

import org.com.framework.bean.SysMenu;

public interface ISysMenuService {

	List<SysMenu> findByPage(SysMenu menu);

	void saveMenu(SysMenu menu);

	void deleteMenu(String ids);
	
	long findMenuCount(SysMenu menu);

	SysMenu getMenuById(Integer id);

	List<SysMenu> findMenuTree(SysMenu menu);

	boolean checkChildren(String ids);
}
