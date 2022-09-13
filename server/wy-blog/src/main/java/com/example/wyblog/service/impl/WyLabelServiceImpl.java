package com.example.wyblog.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.wyblog.mapper.WyLabelMapper;
import com.example.wyblog.model.blog.WyLabel;
import com.example.wyblog.service.IWyLabelService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 标签表 服务实现类
 * </p>
 *
 * @author wangy
 * @since 2022-09-13
 */
@Service
public class WyLabelServiceImpl extends ServiceImpl<WyLabelMapper, WyLabel> implements IWyLabelService {

}
