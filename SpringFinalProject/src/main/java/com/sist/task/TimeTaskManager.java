package com.sist.task;

import javax.servlet.http.HttpServletRequest;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class TimeTaskManager{
   @Scheduled(fixedRate = 6000)
   public void dateUpdate()
   {
	   // where sysdate<hiredate
   }
}
