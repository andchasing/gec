package com.gec;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.gec.system.util.OssConfig;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class TestUpload {
    @Test
    public void testup () throws FileNotFoundException {
        // 区域
//        String endpoint = "http://oss-cn-guangzhou.aliyuncs.com";
        OssConfig ossConfig = new OssConfig();
        System.out.println("id:"+ossConfig.getAccessKeyId()+" aks:"+ossConfig.getAccessKeySecret()+" ep:"+ossConfig.getEndpoint());
        String endpoint = ossConfig.getEndpoint();

        // 秘钥
//        String accessKeyId = "LTAI5tJaiXBZZ6UU5w7JDkmf";
        String accessKeyId = ossConfig.getAccessKeyId();
//        String accessKeySecret = "DPItG7t3MNvBEysb00368IRrBn61aH";
        String accessKeySecret = ossConfig.getAccessKeySecret();

        //创建oss客户端
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 上传文件
        InputStream inputStream = new FileInputStream("J:\\文档\\406\\学生证\\fengmian.jpg");
        ossClient.putObject("move-ch", "abc1.jpg", inputStream);

        // 关闭OSSClient。
        ossClient.shutdown();
    }
}
