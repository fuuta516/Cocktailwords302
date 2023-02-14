package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Cocktailrecipe;
import com.example.demo.repository.CocktailrecipeRepository;



/**
 * ユーザー情報 Service
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CocktailrecipeService {
  /**
   * カクテル言葉
   */
  @Autowired
  private CocktailrecipeRepository cocktailrecipeRepository;

  /**
   * カクテルレシピ　全件
   */
  public List<Cocktailrecipe> searchAll() {
    return cocktailrecipeRepository.findAll();
  }
  
  /**
   * カクテルレシピ　カクテル名検索
   */
  public Cocktailrecipe findByIdcategory(String cocktailwordsname) {
	  List<Cocktailrecipe> list = searchAll();
	  Cocktailrecipe cocktailrecipe  = null;
	  for(int i = 0; i<list.size(); i++) {
		  if(list.get(i).getCocktailwordsname().equals(cocktailwordsname) ){
			  cocktailrecipe = list.get(i);
		  }
	  }
    return cocktailrecipe;
  }

}