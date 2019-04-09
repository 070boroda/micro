package by.zelenko.micro.zuulauthservice.Controller;

import by.zelenko.micro.zuulauthservice.entity.ApplicationUser;
import by.zelenko.micro.zuulauthservice.repository.ApplicationUserRepository;
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

/*    public UserController(ApplicationUserRepository applicationUserRepository, BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        this.applicationUserRepository = applicationUserRepository;
    }*/

    @PostMapping("/signup")
    public void signUp(@RequestBody ApplicationUser applicationUser){
        log.info("seting password");
        applicationUser.setPassword(passwordEncoder.encode(applicationUser.getPassword()));
        log.info("password was setting, try save user in DB");
        applicationUserRepository.save(applicationUser);
        log.info("User saved in DB");
    }
}
