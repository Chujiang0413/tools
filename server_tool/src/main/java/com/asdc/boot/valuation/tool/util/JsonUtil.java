package com.asdc.boot.valuation.tool.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.util.List;
/**
 * @author chujiangjiang
 * @date 2019-08-31
 * @description JSON工具类
 */
@Slf4j
public class JsonUtil {

    private static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);


    /**
     * 返回结果
     *
     * @param total
     * @param pageIndex
     * @param pageSize
     * @param object
     * @return
     */
    public static JSONObject toJsonResult(long total, int pageIndex, int pageSize, Object object) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("total", total);
        jsonObject.put("pageIndex", pageIndex);
        jsonObject.put("pageSize", pageSize);
        jsonObject.put("datas", object);
        return jsonObject;
    }

    /**
     * 将JSON字符串转换为对象
     *
     * @param json
     * @param tClass
     * @param <T>
     * @return
     */
    public static <T> T parse(String json, Class<T> tClass) {
        try {
            if (!StringUtils.isEmpty(json)) {
                T t = JSONObject.parseObject(json, tClass);
                return t;
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return null;
    }

    /**
     * 将JSON字符串转换为JSONObject
     *
     * @param json
     * @return
     */
    public static JSONObject parse(String json) {
        try {
            if (!StringUtils.isEmpty(json)) {
                return JSONObject.parseObject(json);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return null;
    }

    /**
     * 将JSON字符串转换为集合对象
     *
     * @param json
     * @param tClass
     * @param <T>
     * @return
     */
    public static <T> List<T> parseArray(String json, Class<T> tClass) {
        try {
            if (!StringUtils.isEmpty(json)) {
                List<T> list = JSONArray.parseArray(json, tClass);
                return list;
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return null;
    }

    /**
     * 将JSON字符串转换为JSONArray
     *
     * @param json
     * @return
     */
    public static JSONArray parseArray(String json) {
        try {
            if (!StringUtils.isEmpty(json)) {
                return JSONArray.parseArray(json);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return null;
    }

    /**
     * 将对象转换为JSON字符串
     *
     * @param t
     * @param <T>
     * @return
     */
    public static <T> String toJson(T t) {
        try {
            return JSONObject.toJSONString(t);
        } catch (Exception e) {
            logger.error("转换JSON字符出错", e.getMessage());
        }
        return null;
    }

    /**
     * 将集合对象转换为JSONArray字符串
     *
     * @param list
     * @param <T>
     * @return
     */
    public static <T> String toJsonArray(List<T> list) {
        try {
            return JSONArray.toJSONString(list);
        } catch (Exception e) {
            logger.error("转换JSONArray字符出错", e.getMessage());
        }
        return null;
    }

}