package com.learningSpringBoot.First.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class MyClass {

    @Autowired
    private DependencyInjection di;
    @GetMapping("abc")
    public String sayHello() {
        return ("<h1>" + di.fun() + "</h1>" );
    }

}
