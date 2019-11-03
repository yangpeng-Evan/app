package com.qf.util;

import com.aliyun.oss.OSSClient;
import com.qf.properties.AliyunProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yangpeng
 */
@Component
public class UploadUtil {

    @Autowired
    private AliyunProperties aliyunProperties;

    public String uploadPic(String key, InputStream inputStream){
        OSSClient client = new OSSClient(aliyunProperties.getEndpoint(), aliyunProperties.getAccessKeyId(),aliyunProperties.getAccessKeySecret());
        URL url = null;
        try {
            //保存文件
            client.putObject(aliyunProperties.getBucketName(), key, inputStream);
            //生成时间
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = null;

            try {
                date = simpleDateFormat.parse("2020-11-11");
            } catch (ParseException e) {
                e.printStackTrace();
            }
            //获取访问路径
                url = client.generatePresignedUrl(aliyunProperties.getBucketName(), key, date);
            } finally {
                client.shutdown();
        }
        return url.toString();
    }
}
