package com.company.respository;

import com.company.customRepository.RoleRepositoryCustom;
import com.company.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer>, RoleRepositoryCustom {
}
