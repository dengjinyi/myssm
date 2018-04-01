package org.com.framework.model;

import java.util.ArrayList;
import java.util.List;


public class PageModel<T> {
	//当前第几页
	private int pageNum;
	//每页行数
	private int pageSize;
	//总记录数
	private int total;
	//数据集合
	private List<T> rows;

	public PageModel() {
		super();
	}

	public PageModel(int total) {
		this.pageNum = 1;
		this.pageSize = 0x7fffffff;
		this.total = total;
		this.rows = new ArrayList<T>();
	}

	public PageModel(int pageNum, int pageSize, int total) {
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.total = total;
		this.rows = new ArrayList<T>();
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	

	
}