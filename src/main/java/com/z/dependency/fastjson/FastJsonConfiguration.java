package com.z.dependency.fastjson;

import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

/**
 * 使用fastjson作为HttpMessageConverters
 * 
 * @date 2018年8月8日
 */
@Configuration
public class FastJsonConfiguration {

	@Bean
	public HttpMessageConverters fastJsonHttpMessageConverters() {
		// 1.需要定义一个Convert转换消息的对象
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
		// 2.添加fastjson的配置信息，比如是否要格式化返回的json数据
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		// 格式化json
		// fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		// 设置日期转换格式
		// fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");
		// 3.在convert中添加配置信息
		fastConverter.setFastJsonConfig(fastJsonConfig);
		return new HttpMessageConverters(fastConverter);
	}
}