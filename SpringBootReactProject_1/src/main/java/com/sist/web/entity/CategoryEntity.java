package com.sist.web.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="food_category")
@Getter
@Setter
public class CategoryEntity {
	@Id
	private int cno;
	private String title,subject,poster,link;
}
