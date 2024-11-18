package com.sparta.example.repository;

import com.sparta.example.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MarketRepository extends JpaRepository<Item, Long> {
}
