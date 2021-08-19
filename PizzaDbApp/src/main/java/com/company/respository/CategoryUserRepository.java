package com.company.respository;

import com.company.customRepository.CategoryUserRepositoryCustom;
import com.company.entity.CategoryUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryUserRepository extends JpaRepository<CategoryUser,Integer>, CategoryUserRepositoryCustom {

}
