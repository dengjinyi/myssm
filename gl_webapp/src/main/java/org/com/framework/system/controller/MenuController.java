package org.com.framework.system.controller;

import java.util.List;

import org.com.framework.bean.SysMenu;
import org.com.framework.bean.SysUser;
import org.com.framework.controller.BaseController;
import org.com.framework.service.ISysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping(value="/admin/menu")
public class MenuController extends BaseController{

	private final String basePath="/system/menu";
	
	@Autowired
	private ISysMenuService menuService;
	
	@RequestMapping(value="list")
	public String main(){
		return basePath+"/menuList";
	}
	
	@RequestMapping(value="/ajaxList")
	@ResponseBody
	public String list(SysMenu menu){
		List<SysMenu> list = menuService.findByPage(menu);
		long total = menuService.findMenuCount(menu);
		JSONObject json = new JSONObject();
		json.put("rows", list);
		json.put("total", total);
		return json.toString();
	}
	
	@RequestMapping(value="/menuTree")
	@ResponseBody
	public String menuTree(SysMenu menu){
		List<SysMenu> list = menuService.findMenuTree(menu);
		JSONArray json = JSONArray.fromObject(list);
		return json.toString();
	}
	
	@RequestMapping(value="edit")
	public String edit(Integer id,Model model){
		if(!StringUtils.isEmpty(id)){
			SysMenu menu = menuService.getMenuById(id);
			model.addAttribute("menu", menu);
		}
		return basePath+"/editMenu";
	}
	
	@RequestMapping(value="/save")
	@ResponseBody
	public String save(SysMenu menu){
		menuService.saveMenu(menu);
		return returnMsg("200", "保存成功!"); 
	}
	
	@RequestMapping(value="/delete")
	@ResponseBody
	public String delete(String ids){
		menuService.deleteMenu(ids);
		return returnMsg("200", "删除成功!"); 
	}
	
	
	@RequestMapping(value="/checkChildren")
	@ResponseBody
	public String checkChildren(String ids){
		boolean flag = menuService.checkChildren(ids);
		String msg ="false";
		if(flag){
			msg = "true";
		}
		return returnMsg("200", msg); 
	}
	
}
