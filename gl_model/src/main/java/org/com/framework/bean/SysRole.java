package org.com.framework.bean;

public class SysRole extends BaseEntity {

	//归属机构
	private Integer orgId;
	//角色名称
	private String name;
	//角色编码
	private String code;
	//角色类型
	private String roleType;
	//备注
	private String remark;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
