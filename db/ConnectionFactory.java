package com.db;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionFactory {
	
 private static DataSource ds=null;
 
 static {
	 
	 try {
		 Properties p=new Properties();
		 File file=new File("db.properties");
	FileInputStream fio=new FileInputStream(file);
	p.load(fio);
	
	String url=p.getProperty("db.url");
	String uname=p.getProperty("db.uname");
	String pwd=p.getProperty("db.pwd");
	String poolsize=p.getProperty("db.poolsize");
	
	HikariConfig config=new HikariConfig();
	config.setJdbcUrl(url);
	config.setUsername(uname);
	config.setPassword(pwd);
	config.setMaximumPoolSize(Integer.parseInt(poolsize));
	
	ds=new HikariDataSource(config);
		 	 System.out.println("Connection Sucess");
	 }catch (Exception e) {
		e.printStackTrace();
	}
 }
 
 public static Connection getDbConn() throws Exception {
	return ds.getConnection();
	 
 }


}
