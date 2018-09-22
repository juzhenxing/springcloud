package com.example.serviceribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: JuZhenXing
 * @Date: 2018/9/21 11:36
 * @Description:
 */
@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping("/hi")
    public String home(String name){
        return helloService.hiService(name);
    }

}
