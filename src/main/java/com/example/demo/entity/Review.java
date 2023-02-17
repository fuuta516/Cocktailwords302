package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/*
 * DBから取得したデータの格納庫
 */
@Entity
@Data
@Table(name = "レビュー内容")
public class Review implements Serializable {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "日付")
	private Date hiduke;
	
	@Column(name = "カクテル名")
	private String cocktailwordsname;
	
	@Column(name = "ニックネーム")
	private String nickname;
	
	
	@Column(name = "性別")
	private String gender;
	
	@Column(name = "年代")
	private String age;
	
	@Column(name = "コメント")
	private String comment;
	
	@Column(name = "評価☆")
	private Integer evaluation;
}