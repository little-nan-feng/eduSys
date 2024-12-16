package com.nanfeng.utils;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.converters.ReadConverterContext;
import com.alibaba.excel.converters.WriteConverterContext;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import com.nanfeng.pojo.Notice;

import java.text.SimpleDateFormat;
import java.util.Date;

public class myConverter implements Converter<Date> {

    public static String PATTERN_YYYY_MM_DD = "yyyy-MM-dd";

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(PATTERN_YYYY_MM_DD);

    @Override
    public Date convertToJavaData(ReadConverterContext<?> context) throws Exception {
        return simpleDateFormat.parse(context.getReadCellData().getStringValue());
    }

    @Override
    public WriteCellData<?> convertToExcelData(Date value, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        String formatedDate = simpleDateFormat.format(value);
        return new WriteCellData<>(formatedDate);
    }
}
