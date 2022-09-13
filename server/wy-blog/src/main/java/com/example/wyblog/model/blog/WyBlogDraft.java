package com.example.wyblog.model.blog;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDate;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 博客草稿表
 * </p>
 *
 * @author wangy
 * @since 2022-09-13
 */
@TableName("wy_blog_draft")
@ApiModel(value = "WyBlogDraft对象", description = "博客草稿表")
public class WyBlogDraft implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("序号")
        @TableId(value = "id", type = IdType.AUTO)
      private Long id;

      @ApiModelProperty("博客序号")
      private Long blogId;

      @ApiModelProperty("内容")
      private String content;

      @ApiModelProperty("创建时间")
      private LocalDate createTime;

      @ApiModelProperty("修改时间")
      private LocalDate updateTime;

      @ApiModelProperty("删除标志(0-否 1-是)")
      private Integer delFlag;

    
    public Long getId() {
        return id;
    }

      public void setId(Long id) {
          this.id = id;
      }
    
    public Long getBlogId() {
        return blogId;
    }

      public void setBlogId(Long blogId) {
          this.blogId = blogId;
      }
    
    public String getContent() {
        return content;
    }

      public void setContent(String content) {
          this.content = content;
      }
    
    public LocalDate getCreateTime() {
        return createTime;
    }

      public void setCreateTime(LocalDate createTime) {
          this.createTime = createTime;
      }
    
    public LocalDate getUpdateTime() {
        return updateTime;
    }

      public void setUpdateTime(LocalDate updateTime) {
          this.updateTime = updateTime;
      }
    
    public Integer getDelFlag() {
        return delFlag;
    }

      public void setDelFlag(Integer delFlag) {
          this.delFlag = delFlag;
      }

    @Override
    public String toString() {
        return "WyBlogDraft{" +
              "id=" + id +
                  ", blogId=" + blogId +
                  ", content=" + content +
                  ", createTime=" + createTime +
                  ", updateTime=" + updateTime +
                  ", delFlag=" + delFlag +
              "}";
    }
}
