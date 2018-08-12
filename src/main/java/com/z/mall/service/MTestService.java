package com.z.mall.service;

import com.github.pagehelper.PageInfo;
import com.z.dependency.pagehelper.PageParam;
import com.z.mall.entity.MTest;

public interface MTestService {

	int insert(String name);

	int deleteById(Integer id);

	int updateNameById(Integer id, String name);

	MTest selectById(Integer id);

	PageInfo<MTest> selectPage(PageParam pageParam, String name);
}