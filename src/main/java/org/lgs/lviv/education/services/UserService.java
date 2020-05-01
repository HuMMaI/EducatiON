package org.lgs.lviv.education.services;

import org.lgs.lviv.education.entities.Roles;
import org.lgs.lviv.education.entities.User;
import org.lgs.lviv.education.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {
    private static final Set<Roles> DEFAULT_USER_ROLES = Collections.singleton(Roles.ENROLLEE);

    private final UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void create(User user){
        user.setRoles(DEFAULT_USER_ROLES);

        String encodePassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodePassword);

        userRepository.save(user);
    }

    public Optional<User> findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public void save(User user){
        userRepository.save(user);
    }

    public User findById(int userId) {
        Optional<User> userMaybe = userRepository.findById(userId);

        if (userMaybe.isPresent()){
            return userMaybe.get();
        }

        String message = String.format("User with id %d not found!", userId);
        throw new RuntimeException(message);
    }
}
