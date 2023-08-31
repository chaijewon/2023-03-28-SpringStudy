package com.sist.web.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Getter;
import lombok.Setter;
/*
 *  no int AI PK 
name varchar(51) 
subject varchar(2000) 
content text 
pwd varchar(10) 
regdate datetime 
hit int
 */
@Entity
@Table(name="board")
@DynamicUpdate
@Getter
@Setter
public class BoardEntity {
  @Id
  private int no;
  private String name,subject,content;
  @Column(insertable = true,updatable = false)//추가(insert) , 수정(X)
  private String pwd;
  private int hit;
  @Column(insertable = true,updatable = false)//추가(insert) , 수정(X)
  private String regdate;
  
  @PrePersist
  public void regdate() {
	  this.regdate=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
  }
  
}
