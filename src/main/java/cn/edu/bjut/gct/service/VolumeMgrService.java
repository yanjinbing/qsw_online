package cn.edu.bjut.gct.service;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;

public interface VolumeMgrService {
	public SolrDocumentList getVolume(String volumeID) throws SolrServerException, IOException ;
	public QueryResponse search(String field, String value, int start, int count)throws SolrServerException, IOException ;
}
