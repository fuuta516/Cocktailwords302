package com.example.demo.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * レビュー リクエストデータ（入力されたデータの取得）
 */
@Data
public class ReviewRequest implements Serializable {
  
  private Long id;
  
  private Date hiduke;
	
  private String cocktailwordsname;
  
  private String nickname;
  
  private String gender;
  
  private String age;
  
  private String comment;
  
  private Integer evaluation;
}