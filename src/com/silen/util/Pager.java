package com.silen.util;

/**
 * Pager 类 用于计算 首页、上一页、下一页、尾页,数据库中的起始值，当前页
 * */
public class Pager {
	private int totalRows; // 总行数

	private int pageSize = 2; // 每页显示的行数

	private int totalPage; // 总页数

	private int currentPage; // 当前页数

	public Pager() {
	}

	public Pager(int _totalRows) {
		totalRows = _totalRows; // 获得总行数

		totalPage = totalRows / pageSize; // 计算总页数
		int mod = totalRows % pageSize;
		if (mod > 0) {
			totalPage++;
		}
		currentPage = 1;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;

		pageSize = pageSize == 0 ? 10 : pageSize;
		totalPage = totalRows % pageSize == 0 ? totalRows / pageSize
				: totalRows / pageSize + 1;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

}