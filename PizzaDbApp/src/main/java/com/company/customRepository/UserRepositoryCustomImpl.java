package com.company.customRepository;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.company.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserRepositoryCustomImpl implements UserRepositoryCustom{

    @PersistenceContext
    EntityManager em;


    public boolean updateUser(User u){
           em.merge(u);
           return true;
    }

    public static BCrypt.Hasher crypt = BCrypt.withDefaults();
    public boolean addUser(User u) {
        u.setPassword(crypt.hashToString(4, u.getPassword().toCharArray()));
        em.persist(u);
        return true;
    }

    public boolean removeUser(int id){
      User user = em.find(User.class,id);
      em.remove(user);
      return true;
    }

    public User findById(int id){
        return em.find(User.class,id);
    }

}
