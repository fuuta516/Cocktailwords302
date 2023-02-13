package com.example.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.ReviewRequest;
import com.example.demo.entity.Review;
import com.example.demo.repository.ReviewRepository;



/**
 * ユーザー情報 Service
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ReviewService {
  /**
   * れびゅー
   */
  @Autowired
  private ReviewRepository reviewRepository;

  /**
   * カクテル言葉　全件
   */
  public List<Review> searchAll() {
    return reviewRepository.findAll();
  }
  
  /**
   * カクテル言葉　カテゴリー検索
   */
  public ArrayList<Review> findByIdcategory(String cocktailwordsname) {
	  List<Review> list = searchAll();
	  ArrayList<Review> list2 = new ArrayList<Review>() ;
	  for(int i = 0; i<list.size(); i++) {
		  if(list.get(i).getCocktailwordsname().equals(cocktailwordsname) ){
			  list2.add(list.get(i));
		  }
	  }
    return list2;
  }
  
  public void create(ReviewRequest reviewRequest) {
	    Review review = new Review();
	    Date now = new Date();
	    review.setHiduke(now);
	    review.setCocktailwordsname(reviewRequest.getCocktailwordsname());
	    review.setNickname(reviewRequest.getNickname());
	    review.setGender(reviewRequest.getGender());
	    review.setAge(reviewRequest.getAge());
	    review.setComment(reviewRequest.getComment());
	    review.setEvaluation(reviewRequest.getEvaluation());
	    reviewRepository.save(review);
	  }
  
}