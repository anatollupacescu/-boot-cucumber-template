package com.example;

import com.google.common.collect.ImmutableList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserResource {

    @GetMapping("/user/enabled")
    public List<User> enabledUsers() {
        return ImmutableList.of(new User("iura", 43), new User("grisa", 54));
    }
}
