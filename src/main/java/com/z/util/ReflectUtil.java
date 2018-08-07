package com.z.util;

import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 反射工具类
 * 
 * @date 2018年8月7日
 */
public class ReflectUtil {

	/** getter方法前缀 */
	private static final String GETTER_METHOD_PFX = "get";

	/**
	 * 通过getter从对象中获取属性（非迭代）
	 * 
	 * @date 2018年8月7日
	 * @param o 数据来源对象
	 * @param exceptNull 值为null是是否需要设入结果
	 */
	public static Properties genPropertiesByGetter(Object o) {
		Properties properties = new Properties();
		Method[] methods = o.getClass().getDeclaredMethods();
		for (int i = 0; i < methods.length; ++i) {
			Method m = methods[i];
			String name = genPropertyNameFromGetter(m);
			if (name == null)
				continue;

			try {
				Object value = m.invoke(o);
				if (value != null) // 值不为空
					properties.put(name, value);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return properties;
	}

	/**
	 * @date 2018年8月7日
	 * @return 方法是否为getter
	 */
	private static boolean isGetter(Method m) {
		return m.getName().length() > GETTER_METHOD_PFX.length() && m.getName().startsWith(GETTER_METHOD_PFX) && m.getParameterCount() == 0;
	}

	/**
	 * 若方法为getter方法（{@link #isGetter(Method)}返回true），则通过方法名推断其对应属性名，否则返回null
	 * 
	 * @date 2018年8月7日
	 */
	private static String genPropertyNameFromGetter(Method m) {
		if (!isGetter(m))
			return null;

		String name = m.getName().substring(GETTER_METHOD_PFX.length());
		return name.substring(0, 1).toLowerCase() + name.substring(1);
	}
}