package com.example.demo.Service;

import com.example.demo.Dao.UserMapper;
import com.example.demo.Dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean join(UserDto dto) {

        UserDto user = userMapper.selectOneUser(dto.getId());
        if(user != null)
        {
            return false;
        }
        else
        {
            userMapper.InsertUser(dto);
            return true;
        }
    }

    @Override
    public List<UserDto> getUserList() {
        return userMapper.selectAllUser();
    }
}
