package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Yougo;

public interface YougoRepository extends JpaRepository<Yougo, String>{}
