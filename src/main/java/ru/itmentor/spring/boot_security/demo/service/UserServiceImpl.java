package ru.itmentor.spring.boot_security.demo.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itmentor.spring.boot_security.demo.dto.SaveDto;
import ru.itmentor.spring.boot_security.demo.model.User;
import ru.itmentor.spring.boot_security.demo.repository.UserRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Transactional
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Transactional
    public void save(SaveDto dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setAge(dto.getAge());
        user.setEmail(dto.getEmail());
        userRepository.save(user);
    }

    @Transactional
    public void deleteUserById(long id) {
        userRepository.deleteById(id);
    }

    @Transactional
    public void update(long id, SaveDto dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setAge(dto.getAge());
        user.setEmail(dto.getEmail());
        userRepository.save(user);
    }

    @Transactional
    public User findByEmail(String name){
        return userRepository.findByEmail(name).orElseThrow();
    }
}
