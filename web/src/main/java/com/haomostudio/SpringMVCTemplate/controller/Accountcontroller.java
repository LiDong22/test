package com.haomostudio.SpringMVCTemplate.controller;




import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Controller
@RequestMapping("/account")
public class Accountcontroller {

    //登录
    @RequestMapping("/login")
    public void login(String loginId, String password, HttpServletRequest request, HttpServletResponse response) throws Exception{
         String sql="select password from hm_user where loginid=?";
        Connection connection=Jdbc.connection();
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
         preparedStatement.setString(1,loginId);
        ResultSet resultSet=preparedStatement.executeQuery();
         if (password==resultSet.getString("password")){
             request.getSession().setAttribute("loginid",loginId);
             request.getSession().setAttribute("password",password);
             System.out.println("success");
         }else {
             System.out.println("登陆失败");

         }



    }





}
