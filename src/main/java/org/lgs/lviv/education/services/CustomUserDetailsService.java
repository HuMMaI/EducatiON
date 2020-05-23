package org.lgs.lviv.education.services;

import org.lgs.lviv.education.entities.User;
import org.lgs.lviv.education.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private static final Logger LOG = LoggerFactory.getLogger(CustomUserDetailsService.class);

    private final UserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> userMaybe = userRepository.findByEmail(email);
        return userMaybe
                .map(CustomUserDetails::new)
                .orElseThrow(() -> {
                    LOG.error("No user present with username");
                    return new UsernameNotFoundException("No user present with email: " + email);
                });
    }
}
