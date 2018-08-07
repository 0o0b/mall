package com.z.mall.config.mybatis;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import com.github.pagehelper.PageInterceptor;
import com.z.mall.config.pagehelper.PageHelperProperties;
import com.z.util.ReflectUtil;

/**
 * mybatis配置
 * 
 * @date 2018年8月7日
 */
@Configuration
@EnableTransactionManagement
public class MyBatisConfig implements TransactionManagementConfigurer, ApplicationContextAware {

	public static final String SQL_SESSION_FACTORY = "sqlSessionFactory";

	private ApplicationContext applicationContext;

	@Autowired
	private DataSource dataSource;
	@Autowired
	private MyBatisProperties myBatisProperties;
	@Autowired
	private PageHelperProperties pageHelperProperties;

	@Bean(SQL_SESSION_FACTORY)
	public SqlSessionFactory sqlSessionFactory() {
		System.out.println(222222222);
		System.out.println(myBatisProperties);
		System.out.println(pageHelperProperties);
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		bean.setTypeAliasesPackage(myBatisProperties.getTypeAliasesPackage());

		// 添加分页插件
		Interceptor interceptor = new PageInterceptor();
		interceptor.setProperties(ReflectUtil.genPropertiesByGetter(pageHelperProperties));
		bean.setPlugins(new Interceptor[] { interceptor });

		// 添加XML目录
		try {
			bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(myBatisProperties.getMapperLocations()));
			return bean.getObject();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		System.out.println("bbbbbbbbbbbbbb\n" + applicationContext.getBean(SqlSessionFactory.class));
		return new SqlSessionTemplate(sqlSessionFactory);
	}

	@Bean
	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		return new DataSourceTransactionManager(dataSource);
	}

	// @Bean
	// @ConditionalOnBean(name = SQL_SESSION_FACTORY)
	// @ConditionalOnBean(SqlSessionFactory.class)
	public MapperScannerConfigurer mapperScannerConfigurer() {
		System.out.println("aaaaaaaaaaaaa\n" + applicationContext.getBean(SqlSessionFactory.class));
		System.out.println(333333333);
		System.out.println(myBatisProperties);
		System.out.println(pageHelperProperties);
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		mapperScannerConfigurer.setSqlSessionFactoryBeanName(MyBatisConfig.SQL_SESSION_FACTORY);
		// mapperScannerConfigurer.setBasePackage(myBatisProperties.getBasePackage());
		mapperScannerConfigurer.setBasePackage("com.z.mall.**.dao");
		return mapperScannerConfigurer;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
}