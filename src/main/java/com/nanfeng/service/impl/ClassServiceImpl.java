package com.nanfeng.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nanfeng.pojo.Class;
import com.nanfeng.service.ClassService;
import com.nanfeng.mapper.ClassMapper;
import org.springframework.stereotype.Service;

/**
* @author 29465
* @description 针对表【class】的数据库操作Service实现
* @createDate 2024-12-08 15:45:45
*/
@Service
public class ClassServiceImpl extends ServiceImpl<ClassMapper, Class>
    implements ClassService{

}




