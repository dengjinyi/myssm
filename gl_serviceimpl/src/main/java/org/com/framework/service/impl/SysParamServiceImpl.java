package org.com.framework.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.com.framework.bean.SysParam;
import org.com.framework.model.PageModel;
import org.com.framework.service.ISysParamService;
import org.com.framework.system.mapper.SysParamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;


@Service("sysParamService")
@Scope("prototype")
public class SysParamServiceImpl implements ISysParamService {

	@Autowired
	private SysParamMapper sysParamMapper;
	
	@Override
	public PageModel<SysParam> findByPage(SysParam param,int pageNum,int pageSize) {
		int total = sysParamMapper.findCount(param);
		PageModel<SysParam> pageModel = new PageModel<>(pageNum, pageSize, total);
		PageHelper.startPage(pageNum, pageSize);
		pageModel.setRows(sysParamMapper.findByPage(param));
		return pageModel;
	}

	@Override
	public List<SysParam> findList(SysParam param) {
		return sysParamMapper.findList(param);
	}

	@Override
	public int saveOrUpdate(SysParam param) {
		if(StringUtils.isEmpty(param.getId())){
			return sysParamMapper.save(param);
		}else{
			return sysParamMapper.update(param);
		}
	}

	@Override
	public void deleteById(Integer id) {
		sysParamMapper.deleteById(id);
	}

	@Override
	public int findCount(SysParam param) {
		return sysParamMapper.findCount(param);
	}

	@Override
	public SysParam getById(Integer id) {
		return sysParamMapper.getById(id);
	}

}
