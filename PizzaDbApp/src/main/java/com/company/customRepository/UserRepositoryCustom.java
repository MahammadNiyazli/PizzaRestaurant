package com.company.customRepository;

import com.company.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserRepositoryCustom {

    public boolean updateUser(User u);

    public boolean addUser(User u);

    public boolean removeUser(int id);

    public User findById(int id);

}
