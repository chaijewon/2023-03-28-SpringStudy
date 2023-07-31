package com.sist.vo;
import java.util.*;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class DataBoardVO {
  private int no,hit,filecount;
  private String name,subject,content,pwd,filename,filesize,dbday;
  private List<MultipartFile> files;// 업로드된 파일 저장 
  /*
   *   <input type=file name="files[0]"> => bad request (400)
   */
}
