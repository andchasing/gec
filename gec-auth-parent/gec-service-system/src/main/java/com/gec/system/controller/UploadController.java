package com.gec.system.controller;

import com.gec.system.service.SysMovieService;
import com.gec.system.util.OssTemplate;
import com.gec.system.util.VodTemplate;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
@Api(tags = "视频上传控制器")
@RequestMapping("/admin/system/upload")
@CrossOrigin  // 解决跨域问题
public class UploadController {

    @Autowired
    private OssTemplate ossTemplate;

    @Autowired
    private SysMovieService sysMovieService;

    @Autowired
    private VodTemplate vodTemplate;

    // 上传图片
    @RequestMapping(value = "/uploadImage")
    public String uploadImage(MultipartFile uploadImage) throws IOException {

        String imageUrl = this.ossTemplate.upload(uploadImage.getOriginalFilename(), uploadImage.getInputStream());
        System.out.println("imageUrl==================================="+imageUrl);

        return imageUrl;
    }

    // 上传视频操作
    @RequestMapping(value = "/uploadVideo")
    public String uploadVideo(MultipartFile uploadVideo) throws IOException {
        String videoId = this.vodTemplate.uploadVideo(uploadVideo.getOriginalFilename(), uploadVideo.getInputStream());

        System.out.println("videoId====="+videoId);

        return  videoId;
    }
}