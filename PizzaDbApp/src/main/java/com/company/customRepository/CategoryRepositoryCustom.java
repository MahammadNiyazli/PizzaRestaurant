package com.company.customRepository;

import com.company.entity.Category;
import org.springframework.stereotype.Repository;

public interface CategoryRepositoryCustom {

    public boolean addCategory(Category c);

    public boolean removeCategory(int id);

    public boolean updateCategory(Category c);

}
