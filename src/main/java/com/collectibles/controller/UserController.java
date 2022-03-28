package com.collectibles.controller;

import com.collectibles.domain.dto.UserDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @GetMapping(value="getUsers")
    public List<UserDto> getUsers() {
        return new ArrayList<>();
    }

    @GetMapping(value="getUser")
    public UserDto getUser(Long id) {
        return new UserDto();
    }

    @DeleteMapping(value="deleteUser")
    public void deleteUser(Long id) {
    }

    @PutMapping(value="updateUser")
    public UserDto updateUser(UserDto userDto) {
        return new UserDto();
    }

    @PostMapping(value = "createUser")
    public void createUser(UserDto userDto) {
    }
}
