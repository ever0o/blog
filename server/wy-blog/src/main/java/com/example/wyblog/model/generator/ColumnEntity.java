package com.example.wyblog.model.generator;

import lombok.Data;

/**
 * 列实体
 *
 * @author wangy
 * @date 2022/09/13
 */
@Data
public class ColumnEntity {
    /**
     * 列名
     */
    private String columnName;
    /**
     * 列名类型
     */
    private String dataType;
    /**
     * 列名备注
     */
    private String comments;
    /**
     * 属性名称(第一个字母大写)，如：user_name => UserName
     */
    private String attrName;
    /**
     * 属性名称(第一个字母小写)，如：user_name => userName
     */
    private String attrname;
    /**
     * 属性类型
     */
    private String attrType;
    /**
     * auto_increment
     */
    private String extra;
}
