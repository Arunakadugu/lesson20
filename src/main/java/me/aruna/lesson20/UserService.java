package me.aruna.lesson20;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserData findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Long countByEmail(String email) {
        return userRepository.countByEmail(email);
    }

    public UserData findByUsername(String username) {
        return userRepository.findByEmail(username);
    }

    public void saveUser(UserData userData) {
        //userData.setRoles(Arrays.asList(roleRepository.findByRole("USER")));
        userData.addRoles(roleRepository.findByRole("USER"));
        userData.setEnabled(true);
        userRepository.save(userData);
    }

    public void saveAdmin(UserData userData) {
        // userData.setRoles(Arrays.asList(roleRepository.findByRole("ADMIN")));
        userData.addRoles(roleRepository.findByRole("USER"));
        userData.setEnabled(true);
        userRepository.save(userData);
    }
}

