package org.smart4j.framework.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.collections.MapUtils;

import com.kingcodeyu.model.User;

/**
 * 映射操作工具类
 *
 * @author huangyong
 * @since 1.0
 */
public class MapUtil {

    /**
     * 判断 Map 是否非空
     */
    public static boolean isNotEmpty(Map<?, ?> map) {
        return MapUtils.isNotEmpty(map);
    }

    /**
     * 判断 Map 是否为空
     */
    public static boolean isEmpty(Map<?, ?> map) {
        return MapUtils.isEmpty(map);
    }

    /**
     * 转置 Map
     */
    public static <K, V> Map<V, K> invert(Map<K, V> source) {
        Map<V, K> target = null;
        if (isNotEmpty(source)) {
            target = new LinkedHashMap<V, K>(source.size());
            for (Map.Entry<K, V> entry : source.entrySet()) {
                target.put(entry.getValue(), entry.getKey());
            }
        }
        return target;
    }
    public static <T> T mapToBean(Class<T> type, Map<?,?> map)  {  
    	try {
    		BeanInfo beanInfo = Introspector.getBeanInfo(type); // 获取类属性  
            T obj = type.newInstance(); // 创建 JavaBean 对象  
      
            // 给 JavaBean 对象的属性赋值  
            PropertyDescriptor[] propertyDescriptors =  beanInfo.getPropertyDescriptors();  
            for (int i = 0; i< propertyDescriptors.length; i++) {  
                PropertyDescriptor descriptor = propertyDescriptors[i];  
                String propertyName = descriptor.getName();  
      
                if (map.containsKey(propertyName)) {  
                    // 下面一句可以 try 起来，这样当一个属性赋值失败的时候就不会影响其他属性赋值。  
                    Object value = map.get(propertyName);  
                    Object[] args = new Object[1];  
                    args[0] = value;  
                    descriptor.getWriteMethod().invoke(obj, args);  
                }  
            }  
            return obj;  
		} catch (Exception e) {
			// TODO: handle exception
		}
        return null;
    }
    public static void main(String[] args) {
		Map<String,Object> map = new HashMap<>();
		map.put("id", 111);
		map.put("userName","你好名");
		User user = mapToBean(User.class,map);
		System.out.println(user.getId());
	}
}
