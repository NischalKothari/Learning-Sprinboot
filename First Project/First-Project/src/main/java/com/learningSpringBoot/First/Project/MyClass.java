package com.learningSpringBoot.First.Project;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class MyClass {

    @GetMapping("abc")
    public String sayHello() {
        return "<h1>Hi</h1>";
    }
}
