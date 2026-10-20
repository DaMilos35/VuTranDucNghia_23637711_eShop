package com.example.vutranducnghia_23637711_eshop.repository;

import com.example.vutranducnghia_23637711_eshop.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findAllByOrderByNameAsc();
}
