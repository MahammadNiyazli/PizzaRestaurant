package com.company.customRepository;

import com.company.entity.Category;
import com.company.entity.CategoryRole;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CategoryRoleRepositoryCustomImpl implements CategoryRoleRepositoryCustom{

    @PersistenceContext
    EntityManager em;

    @Override
    public boolean addCategoryRole(CategoryRole c) {
        em.persist(c);
        return true;
    }

    @Override
    public boolean removeCategoryRole(int id) {
       em.remove(em.find(CategoryRole.class,id));
       return true;
    }

    @Override
    public boolean updateCategoryRole(CategoryRole c) {
        em.merge(c);
        return true;
    }
}
