package cn.edu.bjut.gct.model;

import java.util.List;

import org.apache.solr.common.SolrDocumentList;

/**
 * 册对象
 * @author yan_jinbing
 *
 */
public class Book {
	private String ID;
	// 册名
	private String name;
	// 起始卷号
	private int volumeNO;
	// 作者列表
	private SolrDocumentList authors;
	// 卷列表
	private List<Volume> volumeList;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public SolrDocumentList getAuthors() {
		return authors;
	}
	public void setAuthors(SolrDocumentList authors) {
		this.authors = authors;
	}
	public int getVolumeNO() {
		return volumeNO;
	}
	public void setVolumeNO(int volumeNO) {
		this.volumeNO = volumeNO;
	}
	public List<Volume> getVolumeList() {
		return volumeList;
	}
	public void setVolumeList(List<Volume> volumeList) {
		this.volumeList = volumeList;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}

}
