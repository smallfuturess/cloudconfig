package Utils;/*
 *  Copyright (c) 2014-2017. 墨博云舟 All Rights Reserved.
 */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.User;

/**
 * Utils.CollectionUtils :
 *
 * @author zhang.lei
 * @version 1.00
 * @since 2017/12/11 20:19
 */
public class CollectionUtils {

    private static Log logger = LogFactory.getLog(CollectionUtils.class);

    /**
     * 描述：返回对象属性&值
     * @return  Map
     * @throws Exception
     */
    public static Map eachProperties(Object model) throws Exception{
        ArrayList list = new ArrayList();
        Field[] field = model.getClass().getDeclaredFields();
        HashMap map = new HashMap();
        int keys;
        String signParam;
        String i;
        Method m;
        Object value;
        String e;
        for(keys = 0; keys < field.length; ++keys) {
            signParam = field[keys].getName();
            i = signParam;
            if (!Character.isLowerCase(signParam.charAt(1)))
            {
                signParam = signParam.substring(0, 1)+ signParam.substring(1);
            }else{
                signParam = signParam.substring(0, 1).toUpperCase()  + signParam.substring(1);
            }
            m = model.getClass().getMethod("get" + signParam, new Class[0]);
            value = m.invoke(model, new Object[0]);
            try {
                e = String.valueOf(value);
                map.put(i, e);
            } catch (Exception var13) {
                logger.error("ERROR", var13);
                var13.printStackTrace();
            }
            list.add(i);
        }
        return map;
    }

    /**
     * 描述：返回对象属性&值的json字符串
     * @return  Map
     * @throws Exception
     */
    public static String eachPropertiesJsonToString(Object model) throws Exception{
         Map map=eachProperties(model);
         String json= JsonUtils.toJson(map);
         return json;
    }



    public static void main(String[] args)  throws Exception{
        Map p=eachProperties(new User("11","22","44"));
    }

}
