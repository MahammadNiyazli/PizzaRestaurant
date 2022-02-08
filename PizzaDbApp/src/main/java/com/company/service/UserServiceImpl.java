package com.company.service;

import com.company.entity.User;
import com.company.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserServiceInter{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean updateUser(User u) {
        return userRepository.updateUser(u);
    }

    @Override
    public boolean addUser(User u) {
        return userRepository.addUser(u);
    }

    @Override
    public boolean removeUser(int id) {
        return userRepository.removeUser(id);
    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }


}
