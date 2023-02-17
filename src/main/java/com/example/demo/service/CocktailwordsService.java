package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collections;
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
  
  public ArrayList<Cocktailwords> findByinitial(String ini){
	  ArrayList<String> list3 = new ArrayList<String>();
	  ArrayList<String> list4 = new ArrayList<String>();
	  
	  for(int i = 0; i<searchAll().size(); i++) {
		  list3.add(searchAll().get(i).getCocktailwordsname());
	  }
	  Collections.sort(list3);
	  
	  for(int i = 0; i<list3.size(); i++) {
		  if(list3.get(i).startsWith(ini)) {
			  list4.add(list3.get(i));
		  }
	  }
	  
	  List<Cocktailwords> list = searchAll();
	  ArrayList<Cocktailwords> list2 = new ArrayList<Cocktailwords>();
	  	  
	  for(int i = 0; i<list4.size(); i++) {
		  for(int j = 0; j<list.size(); j++) {
			  if(list4.get(i).equals(list.get(j).getCocktailwordsname())) {
				  list2.add(list.get(j));
			  }
		  }
	  }
    return list2;
  }

}