package com.nanfeng.service;

import com.nanfeng.pojo.Selection;
import com.baomidou.mybatisplus.extension.service.IService;
import com.nanfeng.utils.Result;

/**
* @author 29465
* @description 针对表【selection】的数据库操作Service
* @createDate 2024-12-08 15:45:46
*/
public interface SelectionService extends IService<Selection> {

    Result getSelection(String id);

    Result setSelection(String sid, Integer cid);

    Result deleteSelection(String sid, Integer cid);
}
