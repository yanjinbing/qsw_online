package cn.edu.bjut.gct.service.impl.base;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.response.QueryResponse;

public class SolrQueryService {
	private String solr_url = "";

	public SolrQueryService(){
		InputStream in = this.getClass().getClassLoader().getResourceAsStream("config.properties");
		Properties p = new Properties();
		try {
			p.load(in);
			solr_url = p.getProperty("solr.url");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	/**
	 * 执行solr查询
	 * 
	 * @return
	 * @throws IOException
	 * @throws SolrServerException
	 */
	public QueryResponse executeQuery(SolrQuery query) throws SolrServerException, IOException {
		SolrClient solr = new HttpSolrClient.Builder(solr_url).build();
		((HttpSolrClient) solr).setParser(new XMLResponseParser());
		return solr.query(query);
	}
	

}
