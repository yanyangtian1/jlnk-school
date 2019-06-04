package cn.javabs.useradd.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;


public class DbcpUtil {
	
	// 1. 定义 静态  quanju变量  DataSource 
	private static  DataSource	ds;
	
	public static DataSource getDataSource(){
		return ds;
	}
	
	public static Connection getConnection() throws SQLException{
		return ds.getConnection();
	}
	
	// 2. 静态代码块
	static{
		
		try {
			//2.1 类名.class.得到类 加载器  . 得到资源作为流  使用字节输入流  进行接收
			InputStream in = DbcpUtil.class.getClassLoader().getResourceAsStream("dbcp.properties");
			
			//2.2 实例化 Properties
			Properties p = new Properties();
			
			//2.3 使用p 加载  in
			p.load(in);
			
			//2.4 基础数据源工厂.创建数据源(p)
			ds = BasicDataSourceFactory.createDataSource(p);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
	}

}
