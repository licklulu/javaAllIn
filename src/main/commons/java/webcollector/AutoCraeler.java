package webcollector;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;
import com.google.gson.*;

public class AutoCraeler extends BreadthCrawler{

    public AutoCraeler(String crawlPath, boolean autoParse) {
        super(crawlPath, autoParse);
        this.addSeed("http://news.hfut.edu.cn/list-1-1.html");
       this.addRegex("http://news.hfut.edu.cn/show.*html");
        /*do not fetch jpg|png|gif*/
        //形如下列参数的url，不进行抓取，jpg文件不要
        this.addRegex( "-.*\\.(jpg|png|gif).*" );
        /*do not fetch url contains #*/
        //任何带#不要
        this.addRegex( "-.*#.*" );
        setThreads(50);
        getConf().setTopN(50);
        setResumable(true);
    }

    @Override
    public void visit(Page page, CrawlDatums next) {
        String url=page.url();
        if (page.matchUrl( "http://news.hfut.edu.cn/show-.*html" )) {
            String title=page.select("div[id=Article]>h2").first().text();
            String content=page.selectText("div#artibody");
            System.out.println("URL:"+url);
            System.out.println("title:"+title);
            System.out.println("content:"+content);
        }
    }
public static void main(String[] args) throws Exception {
    AutoCraeler crawler=new AutoCraeler("qdu", true);
    crawler.start(2);
}
}
