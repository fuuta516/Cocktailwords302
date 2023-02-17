package com.example.demo.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/*
 * DBから取得したデータの格納庫
 */
@Entity
@Data
@Table(name = "カクテルレシピ")
public class Cocktailrecipe implements Serializable {
	
	@Id
	@Column(name = "id")
	private String id;
	
	@Column(name = "言葉カテゴリ")
	private String wordscategory ;
	
	@Column(name = "カクテル名")
	private String cocktailwordsname;
	
	@Column(name = "言葉")
	private String words;
	
	@Column(name = "作り方")
	private String howtomake;
	
	@Column(name = "材料")
	private String material;
}