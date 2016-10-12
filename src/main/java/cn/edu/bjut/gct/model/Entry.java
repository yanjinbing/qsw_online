package cn.edu.bjut.gct.model;

/**
 * 条目对象
 * @author yan_jinbing
 *
 */
public class Entry {
	// 条目号
	private String ID;
	// 标题
	private String title;
	// 正文
	private String data;
	// 原文页码
	private int page;
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}

}
