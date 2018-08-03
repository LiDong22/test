package com.haomostudio.SpringMVCTemplate.controller;

import org.apache.ibatis.io.Resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Jdbc {

         //jdbc连接
    public static Connection connection() throws Exception{

        Properties props = Resources.getResourceAsProperties("dev.properties");
        String url = "jdbc:mysql://haomo-tech.com:3317/org?useUnicode=true&amp;characterEncoding=UTF8";
        String driver ="com.mysql.jdbc.Driver";
        String username ="org";
        String password = "org@haomo";
        Class.forName(driver).newInstance();
        Connection conn = (Connection) DriverManager.getConnection(url, username, password);
       return conn;



    }



}
