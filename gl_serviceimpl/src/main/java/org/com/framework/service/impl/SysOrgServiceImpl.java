package org.com.framework.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.com.framework.bean.SysOrg;
import org.com.framework.service.ISysOrgService;
import org.com.framework.system.mapper.SysOrgMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("orgService")
@Scope("prototype")
public class SysOrgServiceImpl implements ISysOrgService {

	@Autowired
	private SysOrgMapper orgMapper;
	
	@Override
	public List<SysOrg> findList(SysOrg org) {
		return orgMapper.findOrg(org);
	}

	@Override
	public void saveOrUpdate(SysOrg org) {
		if(!StringUtils.isEmpty(org.getId())){
			orgMapper.updateOrg(org);
		}else{
			orgMapper.insertOrg(org);
		}
	}

	@Override
	public void delete(String ids) {
		if(!StringUtils.isEmpty(ids)){
			String[] array = ids.split(",");
			List<Integer> list = new ArrayList<Integer>();
			for(String id : array){
				list.add(Integer.valueOf(id));
			}
			orgMapper.deleteOrg(list);		
		}
	}
	
	public long findCount(SysOrg org){
		return orgMapper.findOrgCount(org);
	}

	@Override
	public SysOrg getById(Integer id) {
		return orgMapper.getOrgById(id);
	}
	

}
