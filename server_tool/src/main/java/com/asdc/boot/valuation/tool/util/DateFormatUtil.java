package com.asdc.boot.valuation.tool.util;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Slf4j
public class DateFormatUtil {

    /**
     * 日期格式转换，中文
     */
    public static String formatDate(String date) throws ParseException {
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MMM-yyyy", Locale.CHINA);
            sdf1.parse(date);
            Date chinaDate = sdf1.parse(String.valueOf(date));
            String newDate = sdf.format(chinaDate);
            return newDate;

        }catch (Exception e){
            log.info("日期转化异常");
            e.printStackTrace();
            return null;
        }

    }
}
