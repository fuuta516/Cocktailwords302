package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Cocktailrecipe;

/**
 * ユーザー情報 Repository（SQLに処理を投げる）
 */
@Repository
public interface CocktailrecipeRepository extends JpaRepository<Cocktailrecipe, String> {}