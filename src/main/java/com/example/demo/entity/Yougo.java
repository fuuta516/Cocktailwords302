package com.example.demo.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "カクテル製法用語")
public class Yougo implements Serializable {
	
	@Id
	@Column(name = "用語")
	private String yougo;
	
	@Column(name = "説明")
	private String mean;
	
}
