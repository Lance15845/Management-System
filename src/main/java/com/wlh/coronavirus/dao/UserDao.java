package com.wlh.coronavirus.dao;

import com.wlh.coronavirus.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {
    //通过username查找User
    @Select("select * from user where username=#{username}")
    @Results({ @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "name", column = "name"),
            @Result(property = "password", column = "password"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "unit", column = "unit")})
    public User findByUsername(String username);
    //添加用户
    @Insert("insert into user(username,password,phone,unit,name)values(#{username},#{password},#{phone},#{unit},#{name})")
    public void addUser(User user);

    //查找所有用户
    @Select("select * from user")
    @Results({ @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "name", column = "name"),
            @Result(property = "password", column = "password"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "unit", column = "unit")})
    public List<User> findAll();

    //删除用户
    @Delete("delete from user where id=#{id}")
    public void deleteUser(int id);




}
