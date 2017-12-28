package cn.itcast.solrj;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

public class Solrj_first {

	//添加以及更新(本质上先删除后添加)
	@Test
	public void addDocument() throws Exception{
		//创建一个solrServer对象，子类为HttpSolrServer
		//baseURL参数，就是solr服务器的url地址:Http://localhost:8080/solr,此时默认选择的是collection1索引库
		//所以一般选择的是Http://localhost:8080/solr/collection1
		SolrServer solrServer = new HttpSolrServer("Http://localhost:8080/solr/collection1");
		//创建一个SolrInputDocument对象
		SolrInputDocument document = new SolrInputDocument();
		//向文档对象添加域
		document.addField("id", "j1");
		document.addField("title", "客户端的新文档");
		document.addField("name", "文档名字");
		document.addField("content", "客户端第一个文档");
		//把文档对象写入索引库，使用SolrServer
		solrServer.add(document);
		//提交
		solrServer.commit();
	}
	
	//删除
	@Test
	public void deleteDocumentById() throws Exception{
		SolrServer solrServer = new HttpSolrServer("Http://localhost:8080/solr/collection1");
		//solrServer.deleteById("j1");
		solrServer.deleteByQuery("id:j1");
		solrServer.commit();
	}
	
	
}
