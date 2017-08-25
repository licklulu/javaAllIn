package webcollector;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;

public class DDD extends BreadthCrawler{
    /**
     * @param crawlPath crawlPath is the path of the directory which maintains
     *                  information of this crawler
     * @param autoParse if autoParse is true,BreadthCrawler will auto extract
     *                  links which match regex rules from pag
     */
    public DDD(String crawlPath, boolean autoParse) {
      super(crawlPath, autoParse);
          /*add 10 start pages and set their type to "list"
            "list" is not a reserved word, you can use other string instead
           */
      //    添加多个种子
      for (int i = 1; i <= 10; i++) {
        this.addSeed("http://news.hfut.edu.cn/list-1-" + i + ".html", "list");
      }

      setThreads(50);
      getConf().setTopN(100);

      getConf().setExecuteInterval(5000);
      getConf().set("title_prefix", "PREFIX_");
      getConf().set("content_length_limit", 20);
      setResumable(true);
    }

    public static void main(String[] args) throws Exception {

      DDD crawler = new DDD("crawl", false);
      /*start crawl with depth of 4*/
      crawler.start(4);
    }

    @Override
    public void visit(Page page, CrawlDatums next) {
      String url = page.url();

      if (page.matchType("list")) {
              /*if type is "list"*/
              /*detect content page by css selector and mark their types as "content"*/
        next.add(page.links("div[class=' col-lg-8 '] li>a")).type("content");
      } else if (page.matchType("content")) {
              /*if type is "content"*/
              /*extract title and content of news by css selector*/
        String title = page.select("div[id=Article]>h2").first().text();
        String content = page.selectText("div#artibody", 0);

        //read title_prefix and content_length_limit from configuration
        title = getConf().getString("title_prefix") + title;
        content = content.substring(0, getConf().getInteger("content_length_limit"));

        System.out.println("URL:\n" + url);
        System.out.println("title:\n" + title);
        System.out.println("content:\n" + content);
      }

    }
}
