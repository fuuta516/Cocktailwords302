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
@Table(name = "カクテル言葉")
public class Cocktailwords implements Serializable {
	
	@Id
	@Column(name = "id")
	private String id;
	
	@Column(name = "言葉カテゴリ") 
	private String wordscategory ;
	
	@Column(name = "カクテル名")
	private String cocktailwordsname;
	
	@Column(name = "言葉")
	private String words;
}