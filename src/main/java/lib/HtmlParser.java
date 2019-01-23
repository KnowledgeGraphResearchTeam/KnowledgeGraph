package lib;

import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.apache.http.HttpResponse;
import org.jsoup.nodes.Document;

import java.io.IOException;


/**
 * @HtmlParser: Html解析器的抽象类
 * @parser(): 需要Override的抽象方法,自定义解析器
 * @parse: final方法，接受一个HttpResponse对象作为参数，返回一个Jsoup的Document对象或抛出IO异常
 */
public abstract class HtmlParser {

    public final Document parse(HttpResponse response) throws IOException{
        HttpEntity entity=response.getEntity();
        String html;
        try{
            html=EntityUtils.toString(entity);
            return Jsoup.parse(html);
        }catch (IOException e) {
            throw e;
        }
    }

    public abstract void parser(Document response);
}
