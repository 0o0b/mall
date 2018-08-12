package com.z.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.z.dependency.pagehelper.PageParam;
import com.z.mall.entity.MTest;
import com.z.mall.service.MTestService;

@RestController
@RequestMapping("/mTest")
public class MTestController {

	@Autowired
	private MTestService mTestService;

	@RequestMapping("/insert")
	public int insert(String name) {
		return mTestService.insert(name);
	}

	@RequestMapping("/deleteById")
	public int deleteById(Integer id) {
		return mTestService.deleteById(id);
	}

	@RequestMapping("/updateNameById")
	public int updateNameById(Integer id, String name) {
		return mTestService.updateNameById(id, name);
	}

	@RequestMapping("/selectById")
	public MTest selectById(Integer id) {
		return mTestService.selectById(id);
	}

	@RequestMapping("/selectPage")
	public PageInfo<MTest> selectPage(PageParam pageParam, String name) {
		return mTestService.selectPage(pageParam, name);
	}
}