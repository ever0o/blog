package com.example.wyblog.util;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;

import java.util.Collections;

/**
 * 代码生成
 * 第一版代码生成器，针对于前端界面还没有完善，仅从后端生成
 *
 * @author wangy
 * @date 2022/09/13
 */
public class CodeGeneration{
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://47.106.103.122:3306/wy_blog?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&useSSL=false&zeroDateTimeBehavior=convertToNull&serverTimezone=Asia/Shanghai", "root", "")
                .globalConfig(builder -> {
                    builder.author("wangy") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("D://generationCode"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.example.wyblog") // 设置父包名
                            .moduleName("wy-blog") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "D://generationCode//mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("wy_blog","wy_blog_draft","wy_label") // 设置需要生成的表名
                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
//                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();

    }
}
