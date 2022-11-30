package com.example.demo.reposatries;

import com.example.demo.classes.customer;
import com.example.demo.classes.productLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface productLineReposatory extends JpaRepository<productLine,Long> {
}
