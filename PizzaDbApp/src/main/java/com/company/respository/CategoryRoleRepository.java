package com.company.respository;

import com.company.customRepository.CategoryRoleRepositoryCustom;
import com.company.entity.CategoryRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRoleRepository extends JpaRepository<CategoryRole,Integer>, CategoryRoleRepositoryCustom {

}
