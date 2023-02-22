package com.example.demo.dto;

import java.io.Serializable;
import java.util.Date;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * レビュー リクエストデータ（入力されたデータの取得）
 */
@Data
public class ReviewRequest implements Serializable {
  
  private Long id;
  
  private Date hiduke;
  
  @NotEmpty(message = "ニックネームを入力してください")
  @Size(max = 10, message = "名前は10桁以内で入力してください")
  private String cocktailwordsname;
  
  private String nickname;
  
  private String gender;
  
  private String age;
  
  @Size(max = 50, message = "コメントは50桁以内で入力してください")
  private String comment;
  
  @NotEmpty(message = "評価をしてください")
  private Integer evaluation;
}