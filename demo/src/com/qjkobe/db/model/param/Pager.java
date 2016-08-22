package com.qjkobe.db.model.param;

public interface Pager {

	public Integer getPageSize();

	public void setPageSize(Integer pageSize);

	public Integer getPageCount();

	public void setPageCount(Integer pageCount);

	public Integer getRecordCount();

	public void setRecordCount(Integer recordCount);

	public Integer getPage();

	public void setPage(Integer page);

	public Integer getStart();

}