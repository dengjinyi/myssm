package org.com.framework.system.controller;

import java.util.List;

import org.com.framework.bean.SysRole;
import org.com.framework.controller.BaseController;
import org.com.framework.service.ISysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONObject;

@Controller
@RequestMapping(value="/admin/role")
public class RoleController extends BaseController{

	private final String basePath="/system/role";
	
	@Autowired
	private ISysRoleService roleService;
	
	@RequestMapping(value="list")
	public String main(){
		return basePath+"/roleList";
	}
	
	@RequestMapping(value="/ajaxList")
	@ResponseBody
	public String list(SysRole role){
		List<SysRole> list = roleService.findRole(role);
		long total = roleService.findRoleCount(role);
		JSONObject json = new JSONObject();
		json.put("rows", list);
		json.put("total", total);
		return json.toString();
	}
	
	@RequestMapping(value="edit")
	public String edit(Integer id,Model model){
		if(!StringUtils.isEmpty(id)){
			SysRole role = roleService.getRoleById(id);
			model.addAttribute("role", role);
		}
		return basePath+"/editRole";
	}
	
	@RequestMapping(value="/save")
	@ResponseBody
	public String save(SysRole role){
		roleService.saveRole(role);
		return returnMsg("200", "保存成功!"); 
	}
	
	@RequestMapping(value="/delete")
	@ResponseBody
	public String delete(String ids){
		roleService.deleteRole(ids);
		return returnMsg("200", "删除成功!"); 
	}
}
