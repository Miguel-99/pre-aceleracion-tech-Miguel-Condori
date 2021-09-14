package com.example.demo.services;

import com.example.demo.dto.UserDTO;
import com.example.demo.models.User;



public interface UserService  {
    User findByUsername(String username);
    User save(UserDTO userDTO);

}
