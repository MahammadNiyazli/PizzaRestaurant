package com.company.respository;

import com.company.customRepository.UserRepositoryCustom;
import com.company.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer>, UserRepositoryCustom {
    public User findByEmail(String email);
}
