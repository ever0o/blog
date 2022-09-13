package com.example.wyblog.model.blog;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDate;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 博客主表
 * </p>
 *
 * @author wangy
 * @since 2022-09-13
 */
@TableName("wy_blog")
@ApiModel(value = "WyBlog对象", description = "博客主表")
@Data
public class WyBlog implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("序号")
        @TableId(value = "id", type = IdType.AUTO)
      private Long id;

      @ApiModelProperty("博客名称")
      private String blogName;

      @ApiModelProperty("标签序号")
      private String labelId;

      @ApiModelProperty("类型序号")
      private Long typeId;

      @ApiModelProperty("垃圾箱标志(0-否 1-是)")
      private Integer rubbishFlag;

      @ApiModelProperty("创建时间")
      private LocalDate createTime;

      @ApiModelProperty("修改时间")
      private LocalDate updateTime;

      @ApiModelProperty("删除标志(0-否 1-是)")
      private Integer delFlag;

    @Override
    public String toString() {
        return "WyBlog{" +
              "id=" + id +
                  ", blogName=" + blogName +
                  ", labelId=" + labelId +
                  ", typeId=" + typeId +
                  ", rubbishFlag=" + rubbishFlag +
                  ", createTime=" + createTime +
                  ", updateTime=" + updateTime +
                  ", delFlag=" + delFlag +
              "}";
    }
}
