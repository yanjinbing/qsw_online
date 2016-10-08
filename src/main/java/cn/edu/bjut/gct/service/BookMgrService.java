package cn.edu.bjut.gct.service;

import java.io.IOException;
import java.util.List;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrDocumentList;

import cn.edu.bjut.gct.model.Book;

public interface BookMgrService {
	public SolrDocumentList getAuthors(String publication) throws SolrServerException, IOException;
	public List<Book> getBooks(int catID)throws SolrServerException, IOException;

}
