package org.com.framework.controller;

import net.sf.json.JSONObject;

public class BaseController {

	public String returnMsg(String statuCode,String msg){
		JSONObject json = new JSONObject();
		json.put("statuCode", statuCode);
		json.put("msg", msg);
		return json.toString();
	}
	
	
}
