package cn.edu.bjut.gct.model;

import org.apache.solr.common.SolrDocumentList;

public class Book {
	// 册名
	private String name;
	// 起始卷号
	private int volumeNO;
	// 作者列表
	private SolrDocumentList authors;
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

}
