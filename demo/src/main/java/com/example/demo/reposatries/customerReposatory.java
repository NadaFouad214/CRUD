package com.example.demo.reposatries;

import com.example.demo.classes.customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface customerReposatory extends JpaRepository<customer,Long> {
}
