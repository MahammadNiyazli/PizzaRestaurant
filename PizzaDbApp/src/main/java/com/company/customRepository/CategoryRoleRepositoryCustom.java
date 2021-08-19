package com.company.customRepository;

import com.company.entity.CategoryRole;
import org.springframework.stereotype.Repository;

public interface CategoryRoleRepositoryCustom {

    public boolean addCategoryRole(CategoryRole c);

    public boolean removeCategoryRole(int id);

    public boolean updateCategoryRole(CategoryRole c);
}
