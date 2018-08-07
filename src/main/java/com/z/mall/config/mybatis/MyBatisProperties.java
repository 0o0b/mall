package com.z.mall.config.mybatis;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * mybatis 配置
 * 
 * @date 2018年8月7日
 */
@Configuration
@ConfigurationProperties("mybatis")
public class MyBatisProperties {

	/**
	 * Packages to search for type aliases.
	 * 
	 * @see org.mybatis.spring.SqlSessionFactoryBean#setTypeAliasesPackage
	 */
	private String typeAliasesPackage;

	/**
	 * Locations of MyBatis mapper files that are going to be merged into the {@code SqlSessionFactory}
	 * configuration at runtime.
	 *
	 * This is an alternative to specifying "&lt;sqlmapper&gt;" entries in an MyBatis config file.
	 * This property being based on Spring's resource abstraction also allows for specifying
	 * resource patterns here: e.g. "classpath*:sqlmap/*-mapper.xml".
	 * 
	 * @see org.mybatis.spring.SqlSessionFactoryBean#setMapperLocations
	 */
	private String mapperLocations;

	/**
	 * This property lets you set the base package for your mapper interface files.
	 * <p>
	 * You can set more than one package by using a semicolon or comma as a separator.
	 * <p>
	 * Mappers will be searched for recursively starting in the specified package(s).
	 * 
	 * @see org.mybatis.spring.mapper.MapperScannerConfigurer#setBasePackage
	 */
	private String basePackage;

	public String getTypeAliasesPackage() {
		return typeAliasesPackage;
	}

	public void setTypeAliasesPackage(String typeAliasesPackage) {
		this.typeAliasesPackage = typeAliasesPackage;
	}

	public String getMapperLocations() {
		return mapperLocations;
	}

	public void setMapperLocations(String mapperLocations) {
		this.mapperLocations = mapperLocations;
	}

	public String getBasePackage() {
		return basePackage;
	}

	public void setBasePackage(String basePackage) {
		this.basePackage = basePackage;
	}

	@Override
	public String toString() {
		return "MyBatisProperties [typeAliasesPackage=" + typeAliasesPackage + ", mapperLocations=" + mapperLocations + ", basePackage="
				+ basePackage + "]";
	}
}