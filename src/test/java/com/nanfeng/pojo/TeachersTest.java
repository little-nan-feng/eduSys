package com.nanfeng.pojo;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.nanfeng.mapper.TeachersMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TeachersTest {

    @Autowired
    TeachersMapper teachersMapper;

    @Test
    public void test(){

        LambdaQueryWrapper<Teachers> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Teachers::getTId,"1001");

        Teachers teachers = teachersMapper.selectOne(queryWrapper);
        System.out.println(teachers);

    }
  
}