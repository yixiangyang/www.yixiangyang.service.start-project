package com.yixiangyang.mysql.datasource.aop;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 动态数据源配置,继承自AbstractRoutingDataSource并重写determineCurrentLookupKey方法，
 * 将数据源的切换粒度设置为线程。
 * 定义两个泛型（因为系统使用两个数据源）以表示数据源的类型，并提供线程可见变量CONTEX_THOLDER的获取和修改方法。
 * @author 15138
 *
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

	/**
	 * 本地线程可见变量，存储当前线程使用了哪一种数据源，初始设为Master
	 */
	private static final ThreadLocal<DatabaseType> CONTEX_THOLDER = new ThreadLocal<DatabaseType>() {
		protected DatabaseType initialValue() {
			return DatabaseType.MASTER;
		};
	};
	
	@Override
	protected Object determineCurrentLookupKey() {
		return CONTEX_THOLDER.get();
	}
	
	/**
	 * 数据源类型枚举类：Master主库，Slave从库
	 * @author z_hh  
	 * @date 2018年11月30日
	 */
	public static enum DatabaseType {
		MASTER, SLAVE
	}

	/**
	 * 将当前线程数据源类型设为Master
	 */
	public static void master() {
		CONTEX_THOLDER.set(DatabaseType.MASTER);
	}
 
	/**
	 * 将当前线程数据源类型设为Slave
	 */
	public static void slave() {
		CONTEX_THOLDER.set(DatabaseType.SLAVE);
	}
 
	/**
	 * 设置当前线程数据源类型
	 */
	public static void setDatabaseType(DatabaseType type) {
		CONTEX_THOLDER.set(type);
	}
 
	/**
	 * 获取当前线程数据源类型
	 */
	public static DatabaseType getType() {
		return CONTEX_THOLDER.get();
	}
	
}
