package com.z.dependency.pagehelper;

/**
 * pagehelper 分页参数
 * 
 * @date 2018年8月8日
 */
public class PageParam {

	/** 页码，从1开始，默认值1 */
	private int pageNum = 1;

	/** 页面大小，默认值{@link Integer#MAX_VALUE} */
	private int pageSize = Integer.MAX_VALUE;

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
}