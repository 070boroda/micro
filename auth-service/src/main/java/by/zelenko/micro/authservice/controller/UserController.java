package by.zelenko.micro.authservice.controller;

import by.zelenko.micro.authservice.entity.ApplicationUser;
import by.zelenko.micro.authservice.repository.ApplicationUserRepository;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@NoArgsConstructor
@Slf4j
public class UserController {
    @Autowired
    private ApplicationUserRepository applicationUserRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public void signUp(@RequestBody ApplicationUser applicationUser){
        log.info("setting password");
        applicationUser.setPassword(passwordEncoder.encode(applicationUser.getPassword()));
        log.info("password was setting, try save user in DB");
        applicationUserRepository.save(applicationUser);
        log.info("User saved in DB");
    }
}
