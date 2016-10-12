package cn.edu.bjut.gct.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.stereotype.Service;

import com.hankcs.hanlp.HanLP;

import cn.edu.bjut.gct.service.VolumeMgrService;
import cn.edu.bjut.gct.service.impl.base.SolrQueryService;

@Service
public class VolumeMgrServiceImpl extends SolrQueryService implements VolumeMgrService {

	@Override
	public SolrDocumentList getVolume(String volumeID) throws SolrServerException, IOException {
		SolrQuery query = new SolrQuery();
		query.setRequestHandler("/select");
		query.set("q", "volumeNO:" + volumeID);
		query.set("rows", 1000);
		// query.set("sort", "Child asc");
		return super.executeQuery(query).getResults();
	}
	
	protected QueryResponse mergeHighLighting(QueryResponse response){
		SolrDocumentList docs = response.getResults();
		Map<String, Map<String, List<String>>> hlrs = response.getHighlighting();
		for (SolrDocument doc : docs) {
			Map<String, List<String>> hlr = hlrs.get(doc.get("Identifier"));
			for (String fieldName : doc.getFieldNames()) {
				if (hlr.containsKey(fieldName))
					doc.setField(fieldName, hlr.get(fieldName).get(0));
			}
		}
		return response;
	}

	@Override
	public QueryResponse search(String field, String value, int start, int count) throws SolrServerException, IOException {
		value = HanLP.convertToTraditionalChinese(value);
		StringBuffer qp = new StringBuffer();
		String hl = field;
		if (field.equalsIgnoreCase("all")) {
			qp.append("authors:").append(value);
			qp.append(" OR title:").append(value);
			qp.append(" OR data:").append(value);
			hl = ("authors,title, data");
		} else
			qp.append(field).append(":").append(value);
		SolrQuery query = new SolrQuery();
		query.setRequestHandler("/select");
		query.set("q", qp.toString());
		query.set("hl", "on");
		query.set("hl.fl", hl);
		query.set("start", start);
		query.set("rows", count);
		return mergeHighLighting(executeQuery(query));
	}

}
