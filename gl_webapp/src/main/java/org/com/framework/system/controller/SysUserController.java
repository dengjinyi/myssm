package org.com.framework.system.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.com.framework.bean.SysUser;
import org.com.framework.controller.BaseController;
import org.com.framework.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONObject;

@Controller
@RequestMapping(value="/admin/user")
public class SysUserController extends BaseController{

	private static Logger logger = Logger.getLogger(SysUserController.class.getName());
	private final String basePath = "/system/user";
	
	@Autowired
	private ISysUserService userService;
	
	@RequestMapping(value="list")
	public String main(){
		return basePath+"/userList";
	}
	
	@RequestMapping(value="/ajaxList")
	@ResponseBody
	public String list(SysUser user){
		List<SysUser> list = userService.findUser(user);
		long total = userService.findUserCount(user);
		JSONObject json = new JSONObject();
		json.put("rows", list);
		json.put("total", total);
		return json.toString();
	}
	
	@RequestMapping(value="edit")
	public String edit(Integer id,Model model){
		try{
			if(!StringUtils.isEmpty(id)){
				SysUser user = userService.getUserById(id);
				model.addAttribute("user", user);
			}
		}catch(Exception e){
			logger.error("编辑用户时异常", e);
		}
		return basePath+"/editUser";
	}
	
	@RequestMapping(value="/saveUser")
	@ResponseBody
	public String saveUser(SysUser user){
		userService.saveUser(user);
		return returnMsg("200", "保存成功!"); 
	}
	
	@RequestMapping(value="/deleteUser")
	@ResponseBody
	public String deleteUser(String ids){
		userService.deleteUser(ids);
		return returnMsg("200", "删除成功!"); 
	}
	
	
}
