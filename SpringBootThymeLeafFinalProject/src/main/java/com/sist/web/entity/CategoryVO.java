package com.sist.web.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/*
 *  CNO int 
	TITLE text 
	SUBJECT text 
	POSTER text 
	LINK text
 */
@Entity
@Table(name="food_category")
@Getter
@Setter
public class CategoryVO {
  @Id
  private int cno;
  private String title,subject,poster,link;
}




