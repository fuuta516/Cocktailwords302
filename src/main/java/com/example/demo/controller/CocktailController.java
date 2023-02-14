package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dto.ReviewRequest;
import com.example.demo.entity.Cocktailrecipe;
import com.example.demo.entity.Cocktailwords;
import com.example.demo.entity.Review;
import com.example.demo.service.CocktailrecipeService;
import com.example.demo.service.CocktailwordsService;
import com.example.demo.service.ReviewService;

@Controller
public class CocktailController {
	
	@Autowired
	  private CocktailwordsService cocktailwordsService;
	
	@Autowired
	private ReviewService reviewService;
	private CocktailrecipeService cocktailrecipeService;
	
	/*
	 * トップページ表示
	 */
	@GetMapping(value = "/user/toppage")
	public String displaytoppage() {
		return "user/toppage";
	}
	
	/*
	 * カクテル言葉全件（一覧）
	 */
	 @GetMapping(value = "/user/cocktailwords")
	  public String displaycocktailwords(Model model) {
	    List<Cocktailwords> cocktailwords = cocktailwordsService.searchAll();
	    model.addAttribute("cocktailwords", cocktailwords);
	    return "user/gojuuon";
	    
	  }
	 
	 /*
	  * カクテル言葉　カテゴリー検索
	  */
	 @GetMapping(value = "/user/{wordscategory}")
	  public String displaycocktailwordscategory(Model model, String wordscategory) {
	    List<Cocktailwords> cocktailwords = cocktailwordsService.findByIdcategory(wordscategory);
	    model.addAttribute("cocktailwords", cocktailwords);
	    return "user/cocktailwords";
	  }
	 
	 /*
	  * レシピページの呼び出し (カクテル名で絞り込み)
	  */
	 @GetMapping(value = "/user/recipe")
	  public String displayreview(Model model, String cocktailwordsname) {
		Cocktailrecipe cocktailrecipe = cocktailrecipeService.findByIdcategory(cocktailwordsname);
	    List<Review> review = reviewService.findByIdcategory(cocktailwordsname);
	    model.addAttribute("cocktailrecipe", cocktailrecipe);
	    model.addAttribute("review", review);
	  //レシピページにレビュー欄を表示させる
	    model.addAttribute("reviewRequest", new ReviewRequest());
	    return "user/recipe";
	  }
	 
	 /*
	  * レビュー入力時の処理
	  */
	 @RequestMapping(value = "/review/create", method = RequestMethod.POST)
	  public String create(@ModelAttribute ReviewRequest reviewRequest, Model model) {

	    // ユーザー情報の登録
		reviewService.create(reviewRequest);
	    return "redirect:/user/recipe";
	    
	 }

}
