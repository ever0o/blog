package com.example.wyblog.util;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.querys.MySqlQuery;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.keywords.MySqlKeyWordsHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 代码生成
 * 第一版代码生成器，针对于前端界面还没有完善，仅从后端生成
 *
 * @author wangy
 * @date 2022/09/13
 */
public class CodeGeneration {
    public static void main(String[] args) {
        // 表信息
        String[] tables = {"plant_business_info"};

        // 项目模块名
        String module = "blog";

        // 作者
        String author = "wangy";

        // 是否生成VO/DTO相关; 默认不生成；因为tables 如果有多个，最后一个table文件会包含前几个table的文件(只是含文件名)；工具bug
        // 如果要vo、dto这些，建议表 tables 设置成1个，分开跑
        boolean generateVo = true;


        //设置数据源
        DataSourceConfig dataSourceConfig = new DataSourceConfig.Builder("jdbc:mysql://47.106.103.122:3306/wy_blog?useSSL=false","root","")
                .dbQuery(new MySqlQuery())
                .typeConvert(new MySqlTypeConvert())
                .keyWordsHandler(new MySqlKeyWordsHandler())
                .build();
        // 当前项目的路径
        String projectPath = System.getProperty("user.dir") + "\\code-generator";
        // 配置策略
        // 1、全局配置
        GlobalConfig gc = new GlobalConfig.Builder()
                .fileOverride()
                .outputDir(projectPath+"/src/main/java")
                .author(author)
                .enableSwagger()
                .dateType(DateType.TIME_PACK)
                .commentDate("yyyy-MM-dd")

                .build();

        //3、包的配置
        PackageConfig pc = new PackageConfig.Builder()
                .parent("com.example.wyblog")
//                .moduleName(module)
                .entity("entity")
                .service("service")
                .serviceImpl("service.impl")
                .mapper("mapper")
                .xml("mapper")
                .controller("controller")
                .pathInfo(Collections.singletonMap(OutputFile.mapperXml, projectPath+"/src/main/resources/mapper"))
                .build();

        //额外包配置
        Map<String, String> map = new HashMap<>();
        Map<String,Object> customMap = new HashMap<>();
        customMap.put("clientValue", "${application."+ module +".name}");
        customMap.put("clientPath", "${application."+ module +".version}");
        customMap.put("module", module);
        InjectionConfig ic = new InjectionConfig.Builder()
                .beforeOutputFile((tableInfo, objectMap) -> {
                    map.put("res/View" + tableInfo.getEntityName() + "Dto.java", "/templates/viewDto.java.vm");
                    map.put("req/Add" + tableInfo.getEntityName() + "Dto.java", "/templates/addDto.java.vm");
                    map.put("req/Modify" + tableInfo.getEntityName() + "Dto.java", "/templates/modifyDto.java.vm");
                    map.put("req/Query" + tableInfo.getEntityName() + "Dto.java", "/templates/queryDto.java.vm");
                    map.put("client/" + tableInfo.getEntityName() + "Client.java", "/templates/client.java.vm");
                    map.put("client/" + tableInfo.getEntityName() + "ServiceClient.java", "/templates/clientImpl.java.vm");
                    map.put("mapper/" + tableInfo.getEntityName() + "Mapper.java", "/templates/mapstruct.java.vm");
                    map.put("vo/input/Post" + tableInfo.getEntityName() + "Vo.java", "/templates/postVo.java.vm");
                    map.put("vo/input/Put" + tableInfo.getEntityName() + "Vo.java", "/templates/putVo.java.vm");
                    map.put("vo/output/Get" + tableInfo.getEntityName() + "Vo.java", "/templates/getVo.java.vm");
                    map.put("vo/query/Query" + tableInfo.getEntityName() + "Vo.java", "/templates/queryVo.java.vm");

                    System.out.println("tableInfo: " + tableInfo.getEntityName() + " objectMap: " + objectMap.size());
                })
                //.customMap(Collections.singletonMap("module", module))
                .customMap(customMap)
                .customFile(map)
                .build();


        //4、策略配置
        StrategyConfig strategy = new StrategyConfig.Builder()
                .addInclude(tables)
                .enableCapitalMode()
                .enableSkipView()
                .disableSqlFilter()
                .addTablePrefix("my_", "sys_")
                .entityBuilder()
                .superClass("com.cnatii.chainge.common.base.entity.BaseEntity")
                .enableChainModel()
                .enableLombok()
                .enableRemoveIsPrefix()
                .enableTableFieldAnnotation()
                .enableActiveRecord()
                .naming(NamingStrategy.underline_to_camel)
                .columnNaming(NamingStrategy.underline_to_camel)
                .addSuperEntityColumns("id","create_time", "update_time","del_flag")
                .formatFileName("%s")
                .controllerBuilder()
                .superClass("com.cnatii.chainge.common.base.controller.BaseController")
                .enableHyphenStyle()
                .enableRestStyle()
                .formatFileName("%sController")
                .serviceBuilder()
                .superServiceClass(IService.class)
                .superServiceImplClass(ServiceImpl.class)
                .formatServiceFileName("%sBiz")
                .formatServiceImplFileName("%sBizImpl")
                .mapperBuilder()
                .superClass(BaseMapper.class)
                .enableMapperAnnotation()
                .enableBaseResultMap()
                .enableBaseColumnList()
                .formatMapperFileName("%sDao")
                .formatXmlFileName("%sDao")
                .build();

        //模板生成器
        TemplateConfig tc = new TemplateConfig.Builder()
                .entity("/templates/entity.java")
                .service("/templates/service.java")
                .serviceImpl("/templates/serviceImpl.java")
                .mapper("/templates/mapper.java")
                .mapperXml("/templates/mapper.xml")
                .controller("/templates/controller.java")
                .build();
        AutoGenerator mpg = new AutoGenerator(dataSourceConfig);
        mpg.global(gc)
                .packageInfo(pc)
                .strategy(strategy)
                .injection(generateVo ? ic : null)
                .template(tc)
                .execute();
    }
}
