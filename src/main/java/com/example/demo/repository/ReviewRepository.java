
package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Review;

/**
 * ユーザー情報 RepositorySQLに処理を投げる）
 */
@Repository
public interface ReviewRepository extends JpaRepository<Review, String> {}  