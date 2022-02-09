package com.company.customRepository;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.company.entity.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository
public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    @PersistenceContext
    EntityManager em;


    public boolean updateUser(User u) {
        if(u.getPassword()!=null) u.setPassword(crypt.hashToString(4, u.getPassword().toCharArray()));
        try {
            User userInDataBase = em.find(User.class, u.getId());
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.getConfiguration().setSkipNullEnabled(true).setMatchingStrategy(MatchingStrategies.STRICT);
            modelMapper.map(u,userInDataBase);
            System.out.println(userInDataBase);
            em.merge(userInDataBase);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

        return true;
    }

    public static BCrypt.Hasher crypt = BCrypt.withDefaults();

    public boolean addUser(User u) {
        u.setPassword(crypt.hashToString(4, u.getPassword().toCharArray()));
        em.persist(u);
        return true;
    }

    public boolean removeUser(int id) {
        User user = em.find(User.class, id);
        em.remove(user);
        return true;
    }

    public User findById(int id) {
        return em.find(User.class, id);
    }

}
