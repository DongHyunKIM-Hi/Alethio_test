package com.example.demo.repository;

import com.example.demo.model.entity.Clothes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClothesRepository extends JpaRepository<Clothes,Long> {
}
