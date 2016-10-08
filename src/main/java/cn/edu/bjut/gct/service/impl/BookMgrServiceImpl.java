package cn.edu.bjut.gct.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.stereotype.Service;

import cn.edu.bjut.gct.model.Book;
import cn.edu.bjut.gct.service.BookMgrService;
import cn.edu.bjut.gct.service.impl.base.SolrQueryService;
import cn.edu.bjut.gct.web.TagsFunction;

@Service
public class BookMgrServiceImpl extends SolrQueryService implements BookMgrService {

	protected SolrDocumentList removeDup(SolrDocumentList docs, String fieldName) {

		SolrDocumentList newDocs = new SolrDocumentList();
		Map<String, SolrDocument> docMap = new HashMap<String, SolrDocument>();

		for (SolrDocument doc : docs) {
			if (!docMap.containsKey(doc.getFieldValue(fieldName))) {
				newDocs.add(doc);
				docMap.put((String) doc.getFieldValue(fieldName), doc);
			}
		}
		return newDocs;
	}

	@Override
	public SolrDocumentList getAuthors(String publication) throws SolrServerException, IOException {
		SolrQuery query = new SolrQuery();
		query.setRequestHandler("/select");
		query.set("q", "Level:4 AND publication:" + publication);
		query.set("rows", 1000);
		// query.set("sort", "Child asc");
		return removeDup(super.executeQuery(query).getResults(), "authors");
	}

	/**
	 * 根据分类ID返回图书信息.元数据缺少图书册号，临时采用约定的方案。该方案有大量的假设
	 * 等数据加工完成，提供册号，改成直接使用册号查询的方式
	 * 
	 * @throws IOException
	 * @throws SolrServerException
	 */
	@Override
	public List<Book> getBooks(int catID) throws SolrServerException, IOException {
		String[] ids = TagsFunction.formatBookID(catID*8+1, 8).split(",");
		ArrayList<Book> books = new ArrayList<Book>();
		for (String id : ids) {
			Book book = new Book();
			book.setName(id);
			book.setAuthors(getAuthors(book.getName()));
			book.setVolumeNO((int) book.getAuthors().get(0).getFieldValue("volumeNO"));
			books.add(book);
		}
		return books;
	}


}
