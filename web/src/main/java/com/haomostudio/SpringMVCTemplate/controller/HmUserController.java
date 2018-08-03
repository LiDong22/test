package com.haomostudio.SpringMVCTemplate.controller;

import cn.jpush.api.report.UsersResult;
import com.haomostudio.SpringMVCTemplate.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/hm-users")
public class HmUserController {

    //创建用户
    @RequestMapping("/createHmUserUsingPOST_1")
    public void createUser(String username,String loginid,String password,String mobile,String email,String avatar){

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:min:ss");
        String createTime=simpleDateFormat.format( new Date());
        String sql="insert into hm_user(username,loginid,password,mobile,email,avatar,creat_time,) values(?,?,?,?,?,?,?)";
        try {
            Connection connection=Jdbc.connection();
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,loginid);
            preparedStatement.setString(3,password);
            preparedStatement.setString(4,mobile);
            preparedStatement.setString(5,email);
            preparedStatement.setString(6,avatar);
            preparedStatement.setString(7,createTime);
            preparedStatement.execute();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    //查询用户
    @RequestMapping("/getHmUserUsingGET")
    public ResultSet selectUser(String id) throws Exception{
        User user=new User();
        Connection connection=Jdbc.connection();
        String sql="select *from hm_user where id=?";
        PreparedStatement preparedStatement =connection.prepareStatement(sql);
        preparedStatement.setString(1,id);
        ResultSet resultSet=preparedStatement.executeQuery();
        connection.close();

        return resultSet;


    }


    //更新用户
    @RequestMapping("/getHmUserUsingPUT")
    public void updateUser(User user) throws Exception{
        Connection connection=Jdbc.connection();
        String sql="update hm_user set loginid=?,username=?,password=?,mobile=?,email=?,avatar=?  where ?=id";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,user.getLoginid());
        preparedStatement.setString(2,user.getUsername());
        preparedStatement.setString(3,user.getPassword());
        preparedStatement.setString(4,user.getMobile());
        preparedStatement.setString(5,user.getEmail());
        preparedStatement.setString(6,user.getAvatar());
        preparedStatement.setString(7,user.getId());
        preparedStatement.execute();
        connection.close();




    }

}
