package com.company.service;

import com.company.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface UserServiceInter {

    public boolean updateUser(User u);

    public boolean addUser(User u);

    public boolean removeUser(int id);

    public User findById(int id);

    public List<User> findAll();

    public Optional<User> findById(Integer id);

    public Page<User> findByFilters(String name, String email, String address, Long id);
}
