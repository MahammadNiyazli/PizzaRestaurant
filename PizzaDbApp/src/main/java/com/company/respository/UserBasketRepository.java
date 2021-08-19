package com.company.respository;

import com.company.customRepository.UserBasketRepositoryCustom;
import com.company.entity.UserBasket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserBasketRepository extends JpaRepository<UserBasket,Integer>, UserBasketRepositoryCustom {
}
