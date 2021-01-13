package lsof.fun.auth.mode.wechat;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestColl2 {

    @GetMapping("/test2")
    public String test() throws ClassNotFoundException {

        System.out.println(getClass());

        return "222222222";
    }

}
