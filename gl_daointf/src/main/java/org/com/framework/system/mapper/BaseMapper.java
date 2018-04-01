package org.com.framework.system.mapper;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.session.RowBounds;


/**
 * 基础功能
 * */
public interface BaseMapper<T> {

	/**
	 * 单个查询
	 * @param id
	 * @return 
	 * */
	T getById(Serializable id);
	
	 /**
     * 查询（根据ID 批量查询）
     * @param idList 主键ID列表
     * @return List<T>
     */
    List<T> findByIds(List<? extends Serializable> idList);
	
	/**
	 * 分页查询
	 * @param entity
	 * @return List
	 * */
	List<T> findByPage(T entity);
	
	/**
	 * 分页查询
	 * @param entity
	 * @return List
	 * */
	List<T> findList(T entity);
	
	/**
	 * 按条件统计查询
	 * @param entity
	 * @return List
	 * */
	int findCount(T entity);
	
	/**
	 * 保存
	 * @param entity
	 * @return int
	 * */
	int save(T entity);
	
	/**
	 * 修改
	 * @param entity
	 * return int
	 * */
	int update(T entity);
	
	/**
	 * 根据id删除
	 * @param id
	 * @return
	 * */
	void deleteById(Serializable id);
	
	/**
     * 删除（根据ID 批量删除）
     *
     * @param idList 主键ID列表
     * @return 
     */
    void deleteByIds(List<? extends Serializable> idList);
}
