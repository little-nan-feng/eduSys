package com.nanfeng.utils;

import com.nanfeng.pojo.Notice;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class ExcelUtil {
    public static List<Notice> excelToNotice(MultipartFile file) throws IOException {
        // 新建一个list，用于存放解析结果
        List<Notice> list = new ArrayList<>();
//        创建一个格式化对象 将excel表中时间字符串转换成日期类型
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        // 拿到对象
        XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
        // 一个excel可能有多个sheet,所以遍历sheet
        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
            // 拿到sheet对象
            XSSFSheet sheet = workbook.getSheetAt(i);
//                System.out.println("行数"+sheet.getPhysicalNumberOfRows());
            // 遍历每一行
            for (int j = 0; j < sheet.getPhysicalNumberOfRows(); j++) {
                //略过首行，即标题行
                if (j == 0) {
                    continue;
                }
                // 拿到行的对象
                XSSFRow row = sheet.getRow(j);
                // 即使你的表格中没有空行，但也可能会被解析出一些空行，所以我们略过空行，否则会报错
                if (row == null) {
                    continue;
                }
//                    System.out.println("列数"+row.getPhysicalNumberOfCells());
                // new一个自己的实体类的对象，方便一会儿将解析出来的值存放进去
                Notice notice = new Notice();

                // 注意下面这种方法是最简单但是也最死板的方法，就是固定excel的表头
                // 每一列只能是对应的字段。一旦excel的某两列相互替换一下位置
                // 那么写入order的值就乱了

                // 遍历一行中的每一个单元格
                for (int k = 0; k < row.getPhysicalNumberOfCells(); k++) {
                    // 写固定了，每一列内容不能变--我的第一列id值不需要传，直接跳过
                    if (k == 0) {
                        //title
                        notice.setTitle(row.getCell(k).getStringCellValue());
                    } else if (k == 1) {
                        // content
                        notice.setContent(row.getCell(k).getStringCellValue());
                    } else if (k == 2) {
                        // 创建时间
                        notice.setTime(row.getCell(k).getDateCellValue());
                    } else if (k == 3) {
                        // 创建者
                        notice.setCreater(row.getCell(k).getStringCellValue());
                    }
                    // 将notice对象添加到list中
                    list.add(notice);
//                    System.out.println(order);
                }
            }
        }
        return list;
    }
}


