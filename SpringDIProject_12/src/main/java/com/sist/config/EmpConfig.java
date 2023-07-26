package com.sist.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
// <context:component-scan base-package="com.sist.*"/>
@ComponentScan(basePackages = "com.sist.*")
// <mybatis-spring:scan base-package="com.sist.mapper" factory-ref="ssf"/>
@MapperScan(basePackages = "com.sist.mapper")
public class EmpConfig {
  /*
   *   <bean id="ds" class="org.apache.commons.dbcp.BasicDataSource"
	      p:driverClassName="oracle.jdbc.driver.OracleDriver"
	      p:url="jdbc:oracle:thin:@localhost:1521:XE"
	      p:username="hr"
	      p:password="happy"
	    />
    <!-- MyBatis -->
    <bean id="ssf" class="org.mybatis.spring.SqlSessionFactoryBean"
      p:dataSource-ref="ds"
    />
   */
	@Bean("ds")
	public DataSource dataSource()
	{
		BasicDataSource ds=new BasicDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		ds.setUsername("hr");
		ds.setPassword("happy");
		return ds;
	}
	@Bean("ssf")
	public SqlSessionFactory sqlSessionFactory() throws Exception
	{
		SqlSessionFactoryBean ssf=new SqlSessionFactoryBean();
		ssf.setDataSource(dataSource());
		
		return ssf.getObject();
	}
}
