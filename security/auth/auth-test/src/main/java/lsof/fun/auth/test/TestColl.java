package lsof.fun.auth.test;

import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestColl {

    @GetMapping("/test")
    public String test() throws ClassNotFoundException {

        System.out.println(getClass());


        Class.forName("lsof.fun.auth.common.config.WebSecurityConfigurerAdapter");

        return null;
    }

}
