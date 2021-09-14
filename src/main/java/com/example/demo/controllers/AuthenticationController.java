package com.example.demo.controllers;

import com.example.demo.dto.UserDTO;
import com.example.demo.models.AuthenticationRequest;
import com.example.demo.models.AuthenticationResponse;
import com.example.demo.models.User;
import com.example.demo.services.UserDetailServiceImpl;
import com.example.demo.services.UserService;
import com.example.demo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/auth")
@CrossOrigin("*")
public class AuthenticationController {

    @Autowired
    private  AuthenticationManager authenticationManager;
    @Autowired
    private  UserService userService;
    @Autowired
    private  UserDetailServiceImpl userDetailService;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping(path = "/register")
    public ResponseEntity<?> createAccount(@RequestBody UserDTO userDTO){
        User user = userService.save(userDTO);
        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> createAuthentication(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        }catch (BadCredentialsException e){
            throw new Exception("Invalid username or password");
        }
        UserDetails userDetails = userDetailService.loadUserByUsername(authenticationRequest.getUsername());
        String jwt = jwtUtil.generateToken(userDetails);
        return new ResponseEntity<>(new AuthenticationResponse(jwt), HttpStatus.ACCEPTED);
    }
}
