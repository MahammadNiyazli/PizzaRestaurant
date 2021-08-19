package com.company.respository;

import com.company.customRepository.CanceledRepositoryCustom;
import com.company.customRepository.UserRepositoryCustom;
import com.company.entity.Canceled;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

public interface CanceledRepository extends JpaRepository<Canceled,Integer>, CanceledRepositoryCustom {

    public Canceled findByDate(Date date);
    public Canceled findByIndentId(int id);
    public List<Canceled> findAllBy();

}
