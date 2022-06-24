package com.spot.task.repository;

import com.spot.task.entity.Country;
import com.spot.task.entity.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryRepo extends JpaRepository<Country,Long> {
}
