package com.example.servicefeign;

import org.springframework.stereotype.Component;

/**
 * @Auther: JuZhenXing
 * @Date: 2018/9/21 14:12
 * @Description:
 */
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry, name";
    }
}
