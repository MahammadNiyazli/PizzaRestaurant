package com.company.respository;

import com.company.customRepository.IndentRepositoryCustom;
import com.company.entity.Indent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndentRepository extends JpaRepository<Indent,Integer>, IndentRepositoryCustom {
}
