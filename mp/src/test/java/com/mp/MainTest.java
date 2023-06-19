package com.mp;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class MainTest {
    public static void main(String[] args){
        FastAutoGenerator.create("jdbc:mysql://172.25.250.111:3306/testssm?useSSL=true&useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC", "root", "1087")
                .globalConfig(builder -> {
                    builder.author("mp2") // 设置作者
                            //.enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("J://mpout"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.mp2") // 设置父包名
                            .moduleName("mp2") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "J://mpout")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("user") // 设置需要生成的表名
                            .addTablePrefix("tb_", "c_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
        System.out.println("ok");
    }
}
