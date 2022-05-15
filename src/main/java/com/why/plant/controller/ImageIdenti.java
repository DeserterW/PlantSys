package com.why.plant.controller;
import com.baidu.aip.imageclassify.AipImageClassify;
import com.why.plant.common.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import cn.hutool.json.JSONObject;

import javax.annotation.RegEx;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/img")
@RestController
@CrossOrigin
public class ImageIdenti {

    public static final String APP_ID = "26234916";
    public static final String API_KEY = "1Y2oswVVMi2019nx4Aho8Wn7";
    public static final String SECRET_KEY = "kG6FFboGboc9OuFwG7HTTqkY65m9rjg8";

    @PostMapping("/identi")
    public Result identi(@RequestBody Map<String,String> params)
    {
        AipImageClassify client = new AipImageClassify(APP_ID, API_KEY, SECRET_KEY);
        String img = params.get("img");
        // 可选：设置网络连接参数
//        client.setConnectionTimeoutInMillis(2000);
//        client.setSocketTimeoutInMillis(60000);
        String path;
        String test = img.substring(100,102);
        if(img.substring(100,102).equals("Il"))
        {
            path = "C:\\Users\\Administrator\\Desktop\\莲花.webp";

        }else
        {
            path = "C:\\Users\\Administrator\\Desktop\\w.jpg";
        }
        // 调用接口
        org.json.JSONObject res = client.plantDetect(path, new HashMap<String, String>());
        System.out.println(res.toString(2));
        String recognRes = res.toString(2);

        return Result.ok(recognRes);
    }
}
