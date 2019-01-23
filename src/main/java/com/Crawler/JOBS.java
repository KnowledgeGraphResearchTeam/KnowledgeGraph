package com.Crawler;

import com.google.gson.reflect.TypeToken;
import lib.Request;
import lib.HtmlParser;
import com.google.gson.GsonBuilder;
import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.*;
import java.util.Random;

public class JOBS extends HtmlParser{

    private Request request;

    /*
    PageGraber: nested class, 用于解析单个页面
     */
    private class PageGraber{

    }

    @Override
    public void parser(Document response) {



    }

    public void start_request(String url){

        /*
        设置this类中的request对象参数：报头、timeout等
         */
        request=new Request(10);

        List<Map<String,String> > user_agents=new ArrayList<Map<String, String> >;

        String jsonStr=this.getClass().getResourceAsStream("User-Agents").toString();

        //TODO 转换json字符串
        Gson gson=new GsonBuilder().enableComplexMapKeySerialization().serializeNulls().disableHtmlEscaping().create();

        user_agents=gson.fromJson(jsonStr, new TypeToken<ArrayList<Map<String, String>>>(){}.getType());


        Random rand=new Random();


        String name=user_agents.get(rand.nextInt(user_agents.size())).entrySet().iterator().next().getKey();

        String value=user_agents.get(rand.nextInt(user_agents.size())).entrySet().iterator().next().getValue();

        request.addHeader(name,value);

        //TODO 开始请求页面
        try{
            HttpResponse response=request.start_request(url,"GET");
            this.parser(this.parse(response));
        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
