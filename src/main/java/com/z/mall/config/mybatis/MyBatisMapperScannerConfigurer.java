package com.z.mall.config.mybatis;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.z.mall.config.pagehelper.PageHelperProperties;

/**
 * MapperScannerConfigurer 配置
 * 
 * @date 2018年8月7日
 */
//@Configuration
//@AutoConfigureAfter(MyBatisConfig.class) // 由于MapperScannerConfigurer执行的比较早，所以必须有该注解
public class MyBatisMapperScannerConfigurer {

	@Autowired
	private MyBatisProperties myBatisProperties;
	@Autowired
	private PageHelperProperties pageHelperProperties;

	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer() {
		System.out.println(11111111);
		System.out.println(myBatisProperties);
		System.out.println(pageHelperProperties);
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		mapperScannerConfigurer.setSqlSessionFactoryBeanName(MyBatisConfig.SQL_SESSION_FACTORY);
		// mapperScannerConfigurer.setBasePackage(myBatisProperties.getBasePackage());
		mapperScannerConfigurer.setBasePackage("com.z.mall.**.dao");
		return mapperScannerConfigurer;
	}
}