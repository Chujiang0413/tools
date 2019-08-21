package com.asdc.boot.valuation.tool.util;

import java.text.DecimalFormat;
import java.util.List;

public class UtilString {

    /**
     * 判断字符串是否为空
     *
     * @Param str
     */
    public static boolean isNull(String str) {
        if (str == null || "".equals(str.trim()) || "null".equals(str.trim())) {
            return true;
        }
        return false;
    }

    /**
     * 将字符串转换成千分位格式
     */
    public static String strFormat(String str) {
        DecimalFormat df;
        if (str.indexOf(".") > 0){
            df = new DecimalFormat("###,##0,0000");
        } else
            df = new DecimalFormat("###,##0");
            double number = 0.0;
            try {
                number = Double.parseDouble(str);
            } catch (Exception e) {
                number = 0.0;
            }
            return df.format(number);
    }

    public static List<String> strSpild(String str){

        return null;
    }
}
