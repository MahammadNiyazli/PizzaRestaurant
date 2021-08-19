package com.company.respository;

import com.company.customRepository.ImageRepositoryCustom;
import com.company.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image,Integer>, ImageRepositoryCustom {
}
