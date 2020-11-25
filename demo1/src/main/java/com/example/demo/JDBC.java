package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.quartz.QuartzProperties;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
class GetUser {
    @Autowired
    DataSource dataSource;
    @GetMapping("/AddUser")
    public boolean GetData(@RequestParam("id") int id, @RequestParam("name")String name, @RequestParam("register") Boolean register) throws SQLException {
        User user = new User();
        user.setName(name);
        user.setRegister(register);
        user.setUser_id(id);
        //JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        Connection connection = dataSource.getConnection();
        String sql = "insert into mybatistest(id,name,register)" +
                " values (?,?,?)";
        PreparedStatement Pre = connection.prepareStatement(sql);
        Pre.setInt(1,user.getUser_id());
        Pre.setString(2,user.getName());
        Pre.setBoolean(3,user.getRegister());
        boolean execute = Pre.execute();
        return execute;


    }
    @Autowired

    @GetMapping("/ConTest")
    public Connection GetConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
        return connection;
    }
    @GetMapping("/ShowInfo")
    public  List<Map<String, Object>> ShowInfo() throws SQLException{
       /* Connection connection = dataSource.getConnection();*/
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "select * from mybatisTest";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;

        //查询
        }

    }



        class User{
        String name;
        int user_id;
        int user_type;
        Boolean register;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getUser_type() {
        return user_type;
    }

    public void setUser_type(int user_type) {
        this.user_type = user_type;
    }

    public Boolean getRegister() {
        return register;
    }

    public void setRegister(Boolean register) {
        this.register = register;
    }
}