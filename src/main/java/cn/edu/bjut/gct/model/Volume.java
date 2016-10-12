package cn.edu.bjut.gct.model;

import java.util.List;

/**
 * 卷对象
 * @author yan_jinbing
 *
 */
public class Volume {
	//卷号
	private String ID;
	//卷名
	private String Name;
	//条目列表
	private List<Entry> entryList;
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public List<Entry> getEntryList() {
		return entryList;
	}
	public void setEntryList(List<Entry> entryList) {
		this.entryList = entryList;
	}

}
