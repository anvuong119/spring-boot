package com.mkyong.repository;

import com.mkyong.model.Car;

import org.springframework.data.jpa.repository.JpaRepository;

// Spring Data JPA creates CRUD implementation at runtime automatically.
public interface CarRepository extends JpaRepository<Car, Long> {
}
