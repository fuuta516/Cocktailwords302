package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Cocktailwords;
import com.example.demo.repository.CocktailwordsRepository;



/**
 * ユーザー情報 Service
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CocktailwordsService {
  /**
   * カクテル言葉
   */
  @Autowired
  private CocktailwordsRepository cocktailwordsRepository;

  /**
   * カクテル言葉　全件
   */
  public List<Cocktailwords> searchAll() {
    return cocktailwordsRepository.findAll();
  }
  
  /**
   * カクテル言葉　カテゴリー検索
   */
  public ArrayList<Cocktailwords> findByIdcategory(String wordscategory) {
	  List<Cocktailwords> list = searchAll();
	  ArrayList<Cocktailwords> list2 = new ArrayList<Cocktailwords>();
	  for(int i = 0; i<list.size(); i++) {
		  if(list.get(i).getWordscategory().equals(wordscategory)) {
			  list2.add(list.get(i));
		  }
	  }
    return list2;
  }
  
  /**
   * カクテル言葉　カクテル名検索
   */
  public ArrayList<Cocktailwords> findByIdname(String cocktailwordsname) {
	  List<Cocktailwords> list = searchAll();
	  ArrayList<Cocktailwords> list2 = new ArrayList<Cocktailwords>();
	  for(int i = 0; i<list.size(); i++) {
		  if(list.get(i).getCocktailwordsname().equals(cocktailwordsname)) {
			  list2.add(list.get(i));
		  }
	  }
    return list2;
  }

}