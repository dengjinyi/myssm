package org.com.framework.bean;

public class SysOrg extends BaseEntity {

	//上级机构
	private Integer parentId;
	//机构名称
	private String name;
	//机构编码
	private String code;
	//是否页子节点
	private Integer isLeaf;
	//机构描述
	private String remark;
	//机构类型
	private Integer orgType;
	//机构级别
	private Integer orgLevel;
	//主负责人
	private Integer fistLeading;
	//副负责人
	private Integer secondLeading;
	//邮政编码
	private String postCode;
	//电话
	private String tel;
	//传真
	private String fax;
	//邮箱
	private String email;
	//归属区域
	private String region;
	//联系地址
	private String address;
	
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Integer getIsLeaf() {
		return isLeaf;
	}
	public void setIsLeaf(Integer isLeaf) {
		this.isLeaf = isLeaf;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getOrgType() {
		return orgType;
	}
	public void setOrgType(Integer orgType) {
		this.orgType = orgType;
	}
	public Integer getOrgLevel() {
		return orgLevel;
	}
	public void setOrgLevel(Integer orgLevel) {
		this.orgLevel = orgLevel;
	}
	public Integer getFistLeading() {
		return fistLeading;
	}
	public void setFistLeading(Integer fistLeading) {
		this.fistLeading = fistLeading;
	}
	public Integer getSecondLeading() {
		return secondLeading;
	}
	public void setSecondLeading(Integer secondLeading) {
		this.secondLeading = secondLeading;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
