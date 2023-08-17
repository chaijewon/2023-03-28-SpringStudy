package com.sist.task;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.text.SimpleDateFormat;
import java.util.*;
public class TimeTaskManager extends TimerTask{
    private HttpServletRequest request;
    public TimeTaskManager(HttpServletRequest request) {
		this.request=request;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		String today=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
		request.setAttribute("today", today);
	}
	
}
