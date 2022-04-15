package com.example.demo.Dao;

import com.example.demo.Dto.UserDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Insert("INSERT INTO user VALUES (#{Id}, #{Pw}, #{Gender})")
    void InsertUser(UserDto dto);
    @Select("SELECT * FROM user WHERE Id=#{Id}")
    UserDto selectOneUser(String Id);
    @Select("SELECT * FROM user")
    List<UserDto> selectAllUser();
}
