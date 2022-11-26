package com.company.service;

import com.company.entity.User;
import com.company.respository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Predicate;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }


    @Override
    public Page<User> findByFilters(String name, String email, String address, Long id) {
        Pageable pageRequest = PageRequest.of(0, 5);
        List<Specification<User>> specifications = new LinkedList<>();
        if (name != null) {
            specifications.add(createSpecification(name,"name"));
        }
        if (email != null) {
            specifications.add(createSpecification(email, "email"));
        }
        if (address != null) {
            specifications.add(createSpecification(address, "address"));
        }

        if (id != null) {
            specifications.add(createSpecification(id, "id"));
        }

        if (specifications.isEmpty()) {
            return userRepository.findAll(pageRequest);
        } else {
            Specification<User> query = Specification.where(specifications.remove(0));
            for (Specification<User> wineSpecification : specifications) {
                query = query.and(wineSpecification);
            }
            return userRepository.findAll(query, pageRequest);
        }
    }

    public  Specification<User> createSpecification(Object input, String columnName) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            Predicate pName = criteriaBuilder.equal(
                    root.get(columnName),
                     input
            );
            return criteriaBuilder.and(pName);
        };
    }
}
