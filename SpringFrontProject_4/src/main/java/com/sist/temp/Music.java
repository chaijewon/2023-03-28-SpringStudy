package com.sist.temp;

import lombok.Getter;
import lombok.Setter;

/*
 *   MNO     int
 CNO     int
 TITLE      VARCHAR(500)
 SINGER      VARCHAR(500)
 ALBUM    VARCHAR(500)
 POSTER       VARCHAR(260)
 IDCREMENT    int
 STATE  VARCHAR(20)
KEY  VARCHAR(30)
 */
@Getter
@Setter
public class Music {
  private int mno,cno,idcrement;
  private String title,singer,album,poster,state,key;
}
