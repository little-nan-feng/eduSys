package com.nanfeng.utils;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.nanfeng.pojo.Notice;
import com.nanfeng.service.NoticeService;
import java.util.List;

/**
 *
 * 自定义的excel解析器 使用easyexcel
 */
// 有个很重要的点 DemoDataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
public class ExcelListener implements ReadListener<Notice> {

    /**
     * 每隔5条存储数据库，实际使用中可以100条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 10;
    /**
     * 缓存的数据
     */
    private List<Notice> noticeList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
    /**
     * 假设这个是一个DAO，当然有业务逻辑这个也可以是一个service。当然如果不用存储这个对象没用。
     */
    private NoticeService noticeService;

    /**
     * 如果使用了spring,请使用这个构造方法。每次创建Listener的时候需要把spring管理的类传进来
     */
    public ExcelListener(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    /**
     * 这个每一条数据解析都会来调用
     */
    @Override
    public void invoke(Notice notice, AnalysisContext context) {
        noticeList.add(notice);
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        if (noticeList.size() >= BATCH_COUNT) {
            saveData();
            // 存储完成清理 list
            noticeList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
        }
    }

    /**
     * 所有数据解析完成了 都会来调用
     *
     * @param context
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // 这里也要保存数据，确保最后遗留的数据也存储到数据库
        saveData();
    }

    /**
     * 加上存储数据库
     */
    private void saveData() {
        noticeService.saveBatch(noticeList);
        System.out.println("存储数据库成功！");
    }
}
