package com.example.wyblog.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.wyblog.mapper.WyBlogMapper;
import com.example.wyblog.model.blog.WyBlog;
import com.example.wyblog.service.IWyBlogService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 博客主表 服务实现类
 * </p>
 *
 * @author wangy
 * @since 2022-09-13
 */
@Service
public class WyBlogServiceImpl extends ServiceImpl<WyBlogMapper, WyBlog> implements IWyBlogService {

}
