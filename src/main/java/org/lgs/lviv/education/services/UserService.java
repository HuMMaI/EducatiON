package org.lgs.lviv.education.services;

import org.lgs.lviv.education.entities.Roles;
import org.lgs.lviv.education.entities.User;
import org.lgs.lviv.education.repositories.UserCoverFileRepository;
import org.lgs.lviv.education.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    private static final Set<Roles> DEFAULT_USER_ROLES = Collections.singleton(Roles.ENROLLEE);

    private final UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private final UserCoverFileRepository userCoverFileRepository;
    private final MailSenderService mailSenderService;

    @Value("${appBaseDomain}")
    private String appBaseDomain;
    @Value("${verifyLink}")
    private String verifyLink;

    @Autowired
    public UserService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            UserCoverFileRepository userCoverFileRepository,
            MailSenderService mailSenderService
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userCoverFileRepository = userCoverFileRepository;
        this.mailSenderService = mailSenderService;
    }

    public void create(User user){
        user.setRoles(DEFAULT_USER_ROLES);

        String encodePassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodePassword);

        user.setEmailVerify(false);

        UUID uuid = UUID.randomUUID();
        user.setVerifyHashCode(uuid.toString());

        String message = String.format(
                "Hi, %s\n" +
                        "Welcome to EducatiON. Please visit next link for activation: %s%s%s",
                user.getFirstName(), appBaseDomain, verifyLink, uuid
        );
        mailSenderService.send(user.getEmail(), "Activation code", message);

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

    public void confirmEmail(String hash) {
        Optional<User> userMaybe = userRepository.findByVerifyHashCode(hash);

        userMaybe.ifPresent(user -> userRepository.confirmEmail(user.getId()));
    }
}
