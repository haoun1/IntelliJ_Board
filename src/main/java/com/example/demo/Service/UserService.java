package com.example.demo.Service;

import com.example.demo.Dto.UserDto;

import java.util.List;

public interface UserService {
    public boolean join(UserDto user);
    public List<UserDto> getUserList();
}
