package com.example.demo.UserMapper;

import com.example.demo.DAO.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    public List<User> QueryForUser();
    public int DeleteById(int id);
    public int UpdateUser(User user);



}
