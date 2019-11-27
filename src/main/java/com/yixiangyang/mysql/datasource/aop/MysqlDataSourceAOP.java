package com.yixiangyang.mysql.datasource.aop;

import java.util.Objects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.yixiangyang.mysql.datasource.aop.DynamicDataSource.DatabaseType;

@Aspect
@Component
@Order(Ordered.LOWEST_PRECEDENCE - 1)

public class MysqlDataSourceAOP {
	private static final Logger log = LoggerFactory.getLogger(MysqlDataSourceAOP.class);
	/**
	 * Master注解
	 * @param pjp
	 * @throws Throwable
	 */
	@Around("@annotation(com.yixiangyang.mysql.datasource.aop.MysqlMaster)")
	public Object setWriteDataSourceType(ProceedingJoinPoint pjp) throws Throwable {
		// 1、当前数据源类型
		DatabaseType currentType = DynamicDataSource.getType();
		try {
			// 2、如果当前是Slave，就切换到Master
			if (Objects.equals(currentType, DatabaseType.SLAVE)) {
				DynamicDataSource.master();
				log.info("dataSource切换到：master");
			}
			// 3、执行目标方法
			return pjp.proceed();
		} catch (Throwable t) {
			log.error("切换数据源异常！", t);
			throw t;
		} finally {
			// 4、需要将数据源还原
			DynamicDataSource.setDatabaseType(currentType);
		}
	}
 
	/**
	 * Slave注解
	 * @param pjp
	 * @throws Throwable
	 */
	@Around("@annotation(com.yixiangyang.mysql.datasource.aop.MysqlSlave) && !@annotation(com.yixiangyang.mysql.datasource.aop.MysqlMaster)")
	public Object setReadDataSourceType(ProceedingJoinPoint pjp) throws Throwable {
		// 1、当前数据源类型
		DatabaseType currentType = DynamicDataSource.getType();
		try {
			// 2、如果当前是Master，就切换到Slave
			if (Objects.equals(currentType, DatabaseType.MASTER)) {
				DynamicDataSource.slave();
				log.info("dataSource切换到：slave");
			}
			// 3、执行目标方法
			return pjp.proceed();
		} catch (Throwable t) {
			log.error("切换数据源异常！", t);
			throw t;
		} finally {
			// 4、需要将数据源还原
			DynamicDataSource.setDatabaseType(currentType);
		}
	}
 
}
