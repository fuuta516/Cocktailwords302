package com.example.demo.entity;

import java.io.Serializable;

import jakarta.persistence.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import lombok.Data;

/*
 * DBから取得したデータの格納庫
 */
@Entity
@Data
@Table(name = "カクテルレシピ")
public class Cocktailrecipe implements Serializable {
	
	@Column(name = "言葉カテゴリ")
	private String wordscategory ;
	
	@Id
	@Column(name = "カクテル名")
	private String cocktailwordsname;
	
	@Column(name = "言葉")
	private String words;
	
	//画像URL
	@Column(name = "url")
	private String imageurl;
	
	@Column(name = "作り方")
	private String howtomake;
	
	@Column(name = "材料")
	private String material;
}