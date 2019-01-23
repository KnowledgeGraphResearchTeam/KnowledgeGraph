package lib;

import java.io.IOException;
import java.net.URLConnection;
import java.net.URL;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;

import org.apache.http.Header;

public class Request{

    private Map<String, String> Headers;

    private Header[] headers;

    private int timeout;

    public Request(){

        Headers=new HashMap<String, String>();

    }

    public Request(Map<String, String> headers) {
        Headers = headers;
    }

    public Request(Map<String, String> headers, Header[] headers1, int timeout) {
        Headers = headers;
        this.headers = headers1;
        this.timeout = timeout;
    }

    public Request(Header[] headers) {
        this.headers = headers;
    }

    public Request(int timeout) {
        this.timeout = timeout;
    }

    public Request(Header[] headers, int timeout) {
        this.headers = headers;
        this.timeout = timeout;
    }

    public Request(Map<String, String> headers, int timeout) {
        Headers = headers;
        this.timeout = timeout;
    }

    public void addHeader(String s, String s1) {
        Headers.put(s,s1);
    }


    public void setHeaders(Map<String, String> headers) {
        Headers = headers;

        Iterator iter=this.Headers.entrySet().iterator();


        int count=0;

        while(iter.hasNext()){
            Map.Entry entry=(Map.Entry)iter.next();
            Object name=entry.getKey();
            Object value=entry.getValue();
            this.headers[count]=new BasicHeader((String)name, (String)value);
            count++;
        }
    }

    public Map<String, String> getHeaders() {
        return this.Headers;
    }

    public void setHeaders(Header[] headers) {
        this.headers=headers;

        for(Header h:this.headers){
            Headers.put(h.getName(),h.getValue());
        }
    }

    public Header[] getAllHeaders() {
        return this.headers;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    /**
     * @Description: 通用的HttpRequest模块
     * @Headers: Http请求的报头
     * @url: 请求的URL地址
     * @method: 请求的方法
     * @Author: song yi
     */

    public HttpResponse start_request(String url, String method) throws IOException {
        if("GET".equals(method)||"get".equals(method)){
            HttpGet get=new HttpGet(url);
            HttpClient client= HttpClients.createDefault();

            get.setHeaders(this.headers);

            RequestConfig.Builder builder=RequestConfig.custom();
            get.setConfig(builder.setConnectTimeout(timeout).build());

            try{
                HttpResponse response=client.execute(get);
                return response;
            }catch (IOException e) {
                throw e;
            }
        } else if("POST".equals(method)||"post".equals(method)){
            HttpPost get=new HttpPost(url);
            HttpClient client= HttpClients.createDefault();

            get.setHeaders(this.headers);

            RequestConfig.Builder builder=RequestConfig.custom();
            get.setConfig(builder.setConnectTimeout(timeout).build());

            try{
                HttpResponse response=client.execute(get);
                return response;
            }catch (IOException e) {
                throw e;
            }
        }else{
            System.out.print("请输入正确的请求方法");
            return null ;
        }

    }

}
