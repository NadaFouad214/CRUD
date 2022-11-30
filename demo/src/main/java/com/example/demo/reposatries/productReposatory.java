package com.example.demo.reposatries;

import com.example.demo.classes.Product;
import com.example.demo.classes.customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface productReposatory extends JpaRepository<Product,Long> {
}
