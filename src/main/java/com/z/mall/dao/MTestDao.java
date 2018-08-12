package com.z.mall.dao;

import java.util.List;

import com.z.base.dao.BaseDao;
import com.z.mall.entity.MTest;

public interface MTestDao extends BaseDao<MTest> {

	List<MTest> selectByName(String name);
}