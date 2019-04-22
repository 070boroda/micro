package by.zelenko.gateway;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Service
@RestController
public class HelloController {

    @GetMapping("/hello")
    public ResponseEntity<String> hello(){
        String hello = "Hello gateway";
        return new ResponseEntity<>(hello, HttpStatus.OK);
    }

}
