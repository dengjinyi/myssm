package org.com.framework.system.mapper;

import java.util.List;

import org.com.framework.bean.SysOrg;

public interface SysOrgMapper {

	List<SysOrg> findOrg(SysOrg user);
	
	void insertOrg(SysOrg user);

	void deleteOrg(List<Integer> ids);
	
	long findOrgCount(SysOrg user);

	SysOrg getOrgById(Integer id);

	void updateOrg(SysOrg user);
}
