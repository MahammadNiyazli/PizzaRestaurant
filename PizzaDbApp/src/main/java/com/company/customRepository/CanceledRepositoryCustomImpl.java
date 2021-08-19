package com.company.customRepository;

import com.company.entity.Canceled;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CanceledRepositoryCustomImpl implements CanceledRepositoryCustom {

    @PersistenceContext
    EntityManager em;


    @Override
    public Canceled updateCanceled(Canceled c) {
        return em.merge(c);
    }

    @Override
    public boolean addCanceled(Canceled c) {
        em.persist(c);
        return true;
    }

    @Override
    public boolean removeCanceled(int id) {
        em.remove(em.find(Canceled.class,id));
        return true;
    }

    @Override
    public Canceled findById(int id) {
        return em.find(Canceled.class,id);
    }
}
