package com.example.demo.services;

import com.example.demo.dto.UserDTO;
import com.example.demo.dto.builder.UserBuilder;
import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private  UserRepository userRepository;

    @Autowired
    private EmailSenderServiceImpl emailSenderService;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User save(UserDTO userDTO) {
        User user = new UserBuilder().withUsuarioDto(userDTO).build();
        user = userRepository.save(user);

        //TODO: agregar envio de link de autenticación
        emailSenderService.send(user.getEmail(), "http://localhost:9000/api/v1/login");
        return user;
    }
}
