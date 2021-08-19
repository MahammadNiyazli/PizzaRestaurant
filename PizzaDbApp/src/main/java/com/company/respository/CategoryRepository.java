package com.company.respository;

import com.company.customRepository.CategoryRepositoryCustom;
import com.company.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer>, CategoryRepositoryCustom {

}
