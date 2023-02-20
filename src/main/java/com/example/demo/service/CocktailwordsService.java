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
		List<Cocktailwords> list = cocktailwordsRepository.findAll();
		ArrayList<String> list2 = new ArrayList<String>();
		
		for(int i = 0; i<list.size(); i++) {
			list2.add(list.get(i).getCocktailwordsname());
		}
		
		Collections.sort(list2);
		
		for(int i = 0; i<list2.size(); i++) {
			for(int j = 0; j<list.size(); j++) {
				if(list2.get(i).equals(list.get(j).getCocktailwordsname())) {
					Cocktailwords c = list.get(i);
					list.set(i, list.get(j));
					list.set(j, c);
				}
			}
		}
		return list;
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

	public ArrayList<Cocktailwords> findByinitial(char ini){
		ArrayList<String> list3 = new ArrayList<String>();
		ArrayList<String> list4 = new ArrayList<String>();

		for(int i = 0; i<searchAll().size(); i++) {
			list3.add(searchAll().get(i).getCocktailwordsname());
		}
		Collections.sort(list3);

		if(ini == 'ア') {
			for(int i = 0; i<list3.size(); i++) {
				if(list3.get(i).charAt(0) >= 'ア' && list3.get(i).charAt(0) <= 'オ'){
					list4.add(list3.get(i));
				}
			}
		}else if(ini == 'カ') {
			for(int i = 0; i<list3.size(); i++) {
				if(list3.get(i).charAt(0) >= 'カ' && list3.get(i).charAt(0) <= 'コ'){
					list4.add(list3.get(i));
				}
			}
		}else if(ini == 'サ') {
			for(int i = 0; i<list3.size(); i++) {
				if(list3.get(i).charAt(0) >= 'サ' && list3.get(i).charAt(0) <= 'ソ'){
					list4.add(list3.get(i));
				}
			}
		}else if(ini == 'タ') {
			for(int i = 0; i<list3.size(); i++) {
				if(list3.get(i).charAt(0) >= 'タ' && list3.get(i).charAt(0) <= 'ト'){
					list4.add(list3.get(i));
				}
			}
		}else if(ini == 'ナ') {
			for(int i = 0; i<list3.size(); i++) {
				if(list3.get(i).charAt(0) >= 'ナ' && list3.get(i).charAt(0) <= 'ノ'){
					list4.add(list3.get(i));
				}
			}
		}else if(ini == 'ハ') {
			for(int i = 0; i<list3.size(); i++) {
				if(list3.get(i).charAt(0) >= 'ハ' && list3.get(i).charAt(0) <= 'ホ'){
					list4.add(list3.get(i));
				}
			}
		}else if(ini == 'マ') {
			for(int i = 0; i<list3.size(); i++) {
				if(list3.get(i).charAt(0) >= 'マ' && list3.get(i).charAt(0) <= 'モ'){
					list4.add(list3.get(i));
				}
			}
		}else if(ini == 'ヤ') {
			for(int i = 0; i<list3.size(); i++) {
				if(list3.get(i).charAt(0) >= 'ヤ' && list3.get(i).charAt(0) <= 'ヨ'){
					list4.add(list3.get(i));
				}
			}
		}else if(ini == 'ラ') {
			for(int i = 0; i<list3.size(); i++) {
				if(list3.get(i).charAt(0) >= 'ラ' && list3.get(i).charAt(0) <= 'ロ'){
					list4.add(list3.get(i));
				}
			}
		}else if(ini == 'ワ') {
			for(int i = 0; i<list3.size(); i++) {
				if(list3.get(i).charAt(0) >= 'ワ' && list3.get(i).charAt(0) <= 'ン'){
					list4.add(list3.get(i));
				}
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