package cn.edu.bjut.gct.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.bjut.gct.model.Book;
import cn.edu.bjut.gct.service.BookMgrService;
import cn.edu.bjut.gct.service.VolumeMgrService;


@Controller
@RequestMapping("/")
public class IndexController {
	@Autowired
	private VolumeMgrService volumeService;
	@Autowired
	private BookMgrService bookService;

	/**
	 * 首页，显示作者列表
	 */
	@RequestMapping("/index.do")
	public String index(Model model, Integer id) throws SolrServerException, IOException {
		if (id == null)
			id = 0;
		ArrayList<Book> books = (ArrayList<Book>) bookService.getBooks(id);
		model.addAttribute("docs", books);
		return "index";
	}

	/**
	 * 头部模板，显示用户信息
	 */
	@RequestMapping("/header.do")
	public String header(Model model, HttpSession session) {
		
		if(session.getAttribute("username") != null){
			model.addAttribute("username", session.getAttribute("username"));
		}
		return "header";
	}

	/**
	 * 搜索页
	 */
	@RequestMapping("/search.do")
	public String search(Model model, String fl, String v, int s, int c) throws SolrServerException, IOException {
		QueryResponse response = volumeService.search(fl, v, s, c);		
		model.addAttribute("docs", response.getResults());
		model.addAttribute("highlight", response.getHighlighting());
		return "search/index";
	}

	/**
	 * 卷详细页
	 */
	@RequestMapping("/detail.do")
	public String detail(Model model, String id) throws SolrServerException, IOException {
		ArrayList<?> docs = volumeService.getVolume(id);
		model.addAttribute("docs", docs);
		return "volume/detail";
	}
}
