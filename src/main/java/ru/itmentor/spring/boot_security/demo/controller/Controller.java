package ru.itmentor.spring.boot_security.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itmentor.spring.boot_security.demo.dto.SaveDto;
import ru.itmentor.spring.boot_security.demo.service.UserService;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody SaveDto dto){
        userService.save(dto);
        return new ResponseEntity<>("User created", HttpStatus.CREATED);
    }


    @DeleteMapping("/delete/{userId}")
    ResponseEntity<String> deleteUserById(@PathVariable String userId) {
        userService.deleteUserById(Long.parseLong(userId));
        return new ResponseEntity<>("User delete", HttpStatus.OK);
    }

    @PutMapping("/update/{userId}")
    ResponseEntity<String> update(@PathVariable String userId, @RequestBody SaveDto dto){
        userService.update(Long.parseLong(userId), dto);
        return new ResponseEntity<>("User updated", HttpStatus.OK);
    }
}
