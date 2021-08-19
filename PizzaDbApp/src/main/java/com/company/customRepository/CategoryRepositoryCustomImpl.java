package com.company.customRepository;

import com.company.entity.Canceled;
import com.company.entity.Category;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CategoryRepositoryCustomImpl implements CategoryRepositoryCustom{

    @PersistenceContext
    EntityManager em;


    @Override
    public boolean addCategory(Category c) {
        em.persist(c);
        return true;
    }

    @Override
    public boolean removeCategory(int id) {
        em.remove(em.find(Category.class,id));
        return true;
    }

    @Override
    public boolean updateCategory(Category c) {
        em.merge(c);
        return true;
    }
}
