package org.com.framework.system.controller;

import java.util.List;

import org.com.framework.bean.SysOrg;
import org.com.framework.controller.BaseController;
import org.com.framework.service.ISysOrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONObject;

@Controller
@RequestMapping(value="/admin/org")
public class OrgController extends BaseController{

	private final String basePath="/system/org";
	
	@Autowired
	private ISysOrgService orgService;
	
	@RequestMapping(value="list")
	public String main(){
		return basePath+"/orgList";
	}
	
	@RequestMapping(value="/ajaxList")
	@ResponseBody
	public String list(SysOrg org){
		List<SysOrg> list = orgService.findList(org);
		long total = orgService.findCount(org);
		JSONObject json = new JSONObject();
		json.put("rows", list);
		json.put("total", total);
		return json.toString();
	}
	
	@RequestMapping(value="edit")
	public String edit(Integer id,Model model){
		if(!StringUtils.isEmpty(id)){
			SysOrg org = orgService.getById(id);
			model.addAttribute("org", org);
		}
		return basePath+"/editOrg";
	}
	
	@RequestMapping(value="/save")
	@ResponseBody
	public String save(SysOrg org){
		orgService.saveOrUpdate(org);
		return returnMsg("200", "保存成功!"); 
	}
	
	@RequestMapping(value="/delete")
	@ResponseBody
	public String delete(String ids){
		orgService.delete(ids);
		return returnMsg("200", "删除成功!"); 
	}
}
