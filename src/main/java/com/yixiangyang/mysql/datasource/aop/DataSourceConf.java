package com.yixiangyang.mysql.datasource.aop;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.zaxxer.hikari.HikariDataSource;



/**
 * 创建动态数据源对象，并创建两个类型的数据源作为其目标数据源，将其默认数据源设置为Master。最后交由Spring IOC容器管理。
 * @author 15138
 *
 */
@Configuration
public class DataSourceConf {
	/**
	 * 将动态数据源注入Spring IOC容器
	 * @return
	 */
	@Bean
	public DataSource dynamicDataSource() {
		DataSource master = master();
		DataSource slave = slave();
		Map<Object, Object> targetDataSources = new HashMap<Object, Object>();
		targetDataSources.put(DynamicDataSource.DatabaseType.MASTER, master);
		targetDataSources.put(DynamicDataSource.DatabaseType.SLAVE, slave);
		DynamicDataSource dataSource = new DynamicDataSource();
		dataSource.setTargetDataSources(targetDataSources);// 该方法是AbstractRoutingDataSource的方法
		dataSource.setDefaultTargetDataSource(master);
		return dataSource;
	}
 
	/**
	 * 创建Master数据源对象
	 * @return
	 */
	public DataSource master() {
		HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl(env.getProperty("master.datasource.url"));
        ds.setUsername(env.getProperty("master.datasource.username"));
        ds.setPassword(env.getProperty("master.datasource.password"));
        ds.setDriverClassName(env.getProperty("master.datasource.driver-class-name"));
		return ds;
	}
 
	/**
	 * 创建Slave数据源对象
	 * @return
	 */
	public DataSource slave() {
		HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl(env.getProperty("slave.datasource.url"));
        ds.setUsername(env.getProperty("slave.datasource.username"));
        ds.setPassword(env.getProperty("slave.datasource.password"));
        ds.setDriverClassName(env.getProperty("slave.datasource.driver-class-name"));
		return ds;
	}
 
	@Autowired
	private Environment env;
}
