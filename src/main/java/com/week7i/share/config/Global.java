package com.week7i.share.config;

import com.google.common.collect.Maps;
import com.week7i.share.util.PropertiesLoader;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * 全局配置类
 * Created by jiangxingqi on 2017/7/27.
 */
public class Global {

    /**
     * 保存全局属性值
     */
    private static Map<String, String> map = Maps.newHashMap();

    /**
     * 属性文件加载对象
     */
    private static PropertiesLoader loader = new PropertiesLoader("jdbc.properties");

    /**
     * 获取配置
     * @see {fns:getConfig('adminPath')}
     */
    public static String getConfig(String key) {
        String value = map.get(key);
        if (value == null){
            value = loader.getProperty(key);
            map.put(key, value != null ? value : StringUtils.EMPTY);
        }
        return value;
    }
}
