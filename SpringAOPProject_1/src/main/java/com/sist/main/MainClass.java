package com.sist.main;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Sawon s=new Sawon();
        s.display();
        Proxy p=new Proxy(s);
        p.display();
	}

}
