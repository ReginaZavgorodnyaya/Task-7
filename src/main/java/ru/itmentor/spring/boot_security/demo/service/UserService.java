package ru.itmentor.spring.boot_security.demo.service;


import ru.itmentor.spring.boot_security.demo.dto.SaveDto;
import ru.itmentor.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    void save(SaveDto dto);

    void deleteUserById(long id);

    void update(long id, SaveDto dto);

    User findByEmail(String name);

}
