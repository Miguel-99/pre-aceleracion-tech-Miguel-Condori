package com.example.demo.services;


import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.User;



@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.example.demo.models.User user = userRepository.findByUsername(username);
        UserBuilder userBuilder = null;

        if (user != null){
            userBuilder = User.withUsername(username);
            userBuilder.disabled(false);
            userBuilder.password(user.getPassword());
            userBuilder.authorities(new SimpleGrantedAuthority("ROL_USER"));
        }else{
            throw new UsernameNotFoundException("Usuario no registrado");
        }
        return userBuilder.build();
    }
}
