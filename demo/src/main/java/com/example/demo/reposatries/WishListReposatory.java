package com.example.demo.reposatries;

import com.example.demo.classes.Cart;
import com.example.demo.classes.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishListReposatory extends JpaRepository<WishList,Long> {

}
