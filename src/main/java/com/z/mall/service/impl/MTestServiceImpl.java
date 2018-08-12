package com.z.mall.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.z.dependency.pagehelper.PageParam;
import com.z.mall.dao.MTestDao;
import com.z.mall.entity.MTest;
import com.z.mall.service.MTestService;
import com.z.util.StringUtil;

@Service
public class MTestServiceImpl implements MTestService {

	@Autowired
	private MTestDao mTestDao;

	@Override
	public int insert(String name) {
		if (StringUtils.isEmpty(name))
			return 0;

		MTest mTest = new MTest();
		mTest.setName(name);
		mTest.setCreateTime(new Date());
		return mTestDao.insert(mTest);
	}

	@Override
	public int deleteById(Integer id) {
		return id == null ? 0 : mTestDao.deleteByPrimaryKey(id);
	}

	@Override
	public int updateNameById(Integer id, String name) {
		if (id == null || StringUtils.isEmpty(name))
			return 0;

		MTest mTest = new MTest();
		mTest.setId(id);
		mTest.setName(name);
		return mTestDao.updateByPrimaryKeySelective(mTest);
	}

	@Override
	public MTest selectById(Integer id) {
		return id == null ? null : mTestDao.selectByPrimaryKey(id);
	}

	@Override
	public PageInfo<MTest> selectPage(PageParam pageParam, String name) {
		PageHelper.startPage(pageParam);
		return new PageInfo<MTest>(mTestDao.selectByName(StringUtil.getNullOrTrim(name)));
	}
}