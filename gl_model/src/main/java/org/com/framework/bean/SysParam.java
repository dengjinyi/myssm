package org.com.framework.bean;

public class SysParam extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8448892840012757551L;
	
	//值
	private String value;
	//标签
	private String title;
	//类型
	private String paramType;
	//排序号
	private Integer orderBy;
	//备注
	private String remark;
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(Integer orderBy) {
		this.orderBy = orderBy;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getParamType() {
		return paramType;
	}
	public void setParamType(String paramType) {
		this.paramType = paramType;
	}
	
	
}
