package kele.util;

import java.util.List;

public class Pager {
	private List<Object> list;
	private int pageIndex = 1;
	private int pageSize = 10;
	private int total = 0;
	private int groupSize=7;

	public Pager(){
		
	}
	public Pager(int pageIndex,int recordCount){
		if (recordCount < 0) {
			recordCount = 0;
			}
		if (pageIndex < 1) {
			pageIndex = 1;
			}
		this.pageIndex=pageIndex;
		this.total=recordCount;
	}
	
	public int getStartIndex() {
		return (pageIndex - 1) * pageSize;
	}

	public String getPagerHtml() {

		StringBuffer strBuf = new StringBuffer();
		strBuf.append("<a " + (isPageStart() ? "disabled=\"disabled\"": "href=\"?page=1\" ") + ">首页</a>");
		strBuf.append("&nbsp;&nbsp;");
		strBuf.append("<a " + (isPageStart() ? "disabled=\"disabled\" ": "href=\"?page="+GetLastPage()+"\" ") +">上一页</a>");
		strBuf.append("&nbsp;&nbsp;");

		for(int i=1;i<=getPageButtonCount()&((getGroupIndex()-1)*groupSize+i)<=getPageTotal();i++){
			strBuf.append("<a href=\"?page="+((getGroupIndex()-1)*groupSize+i)+"\" "+(getPageIndex()==((getGroupIndex()-1)*groupSize+i)?"style='color:#dc7043;'" : null)+">"+((getGroupIndex()-1)*groupSize+i)+"</a>");
			strBuf.append("&nbsp;&nbsp;");			
		}

		strBuf.append("<a "+ (isPageEnd() ? "disabled=\"disabled\"": "href=\"?page="+GetNextPage()+"\" ") +">下一页</a>");
		strBuf.append("&nbsp;&nbsp;");
		strBuf.append("<a " + (isPageEnd() ? "disabled=\"disabled\"": "href=\"?page=" + getPageTotal() + "\" ") + ">尾页</a>");
		return strBuf.toString();
	}
	
	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		if (pageIndex < 1) {
			pageIndex = 1;
		}
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		if (pageSize < 1) {
			pageSize = 1;
		}
		this.pageSize = pageSize;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		if (total < 0) {
			total = 0;
		}
		this.total = total;
	}

	public int getPageTotal() {
		int pageCount = 0;
		if (total > 0) {
			pageCount = total / pageSize;
			if (total % pageSize > 0) {
				pageCount++;
			}
		}
		return pageCount;
	}

	private boolean isPageStart() {
		if (pageIndex == 1) {
			return true;
		} else {
			return false;
		}
	}

	private boolean isPageEnd() {
		if (pageIndex == getPageTotal()) {
			return true;
		} else {
			return false;
		}
	}

	public int getPageButtonCount() {
		return groupSize;
	}
	public void setPageButtonCount(int pageButtonCount) {
		this.groupSize = pageButtonCount;
	}
	
	private int getGroupIndex()
	{
		int groupIndex=getPageIndex()/groupSize+1;
		if(getPageIndex()%getGroupSize()==0){
			groupIndex--;
		}
		return groupIndex;
	}
	private int getGroupSize(){
		return groupSize;
	}

	private int GetLastPage()	{
		if(getPageIndex()>1){
			return getPageIndex()-1;
		}
		else {
			return 1;
		}		
	}

	private int GetNextPage(){
		if(getPageIndex()+1<getPageTotal()){
			return getPageIndex()+1;
		}else{
			return getPageTotal();
		}
	}
	public List<Object> getList() {
		return list;
	}
	public void setList(List<Object> list) {
		this.list = list;
	}

}
