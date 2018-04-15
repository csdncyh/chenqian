package com.chenqian.service.impl;

import com.chenqian.entity.CiBaInfo;
import com.chenqian.service.PageService;
import com.google.gson.Gson;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class PageServiceImpl implements PageService{

    String cibaUrl = "http://open.iciba.com/dsapi/?date=";

    @Override
    public List<CiBaInfo> getCiBaInfo() throws IOException {

        //生成今天和前三天的日期
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 0);
        Date date = null;
        List<CiBaInfo> list = new ArrayList<CiBaInfo>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (int i=0; i<3; i++){
            calendar.add(Calendar.DATE, 0-i);
            date = calendar.getTime();
            String str = cibaUrl+sdf.format(date);
            Document document = Jsoup.connect(str).get();
            String json = document.body().text();
            Gson gson = new Gson();
            CiBaInfo ciBaInfo = gson.fromJson(json, CiBaInfo.class);
            list.add(ciBaInfo);
        }
        return list;
    }
}
