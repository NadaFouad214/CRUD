package com.example.demo.reposatries;

import com.example.demo.classes.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface cartReposatory extends JpaRepository<Cart,Long> {
}
