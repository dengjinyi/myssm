package org.com.framework.system.controller;


import org.apache.commons.lang.StringUtils;
import org.com.framework.bean.SysParam;
import org.com.framework.controller.BaseController;
import org.com.framework.model.PageModel;
import org.com.framework.service.ISysParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONObject;

/**
 * 系统字典参数控制类
 * @author dengjinyi
 * */
@Controller
@RequestMapping(value="/admin/param")
public class SysParamController extends BaseController{

	private final String basePath="/system/param";
	
	@Autowired
	private ISysParamService sysParamService;
	
	@RequestMapping(value="list")
	public String list(){
		return basePath+"/paramList";
	}
	
	@RequestMapping(value="/ajaxList",method = RequestMethod.POST)
	@ResponseBody
	public String ajaxList(SysParam param,Integer pageNumber,Integer pageSize){
		PageModel<SysParam> pageModel = sysParamService.findByPage(param,pageNumber,pageSize);
		JSONObject json = JSONObject.fromObject(pageModel);
		return json.toString();
	}
	
	@RequestMapping(value="edit")
	public String edit(String id,Model model){
		if(!StringUtils.isEmpty(id.toString())){
			SysParam param = sysParamService.getById(Integer.valueOf(id));
			model.addAttribute("param", param);
		}
		return basePath+"/editParam";
	}
	
	@RequestMapping(value="/save")
	@ResponseBody
	public String save(SysParam param){
		sysParamService.saveOrUpdate(param);
		return returnMsg("200", "保存成功!"); 
	}
	
	@RequestMapping(value="/deleteById")
	@ResponseBody
	public String deleteById(Integer id){
		sysParamService.deleteById(id);
		return returnMsg("200", "删除成功!"); 
	}
}
