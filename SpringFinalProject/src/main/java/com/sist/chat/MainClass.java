package com.sist.chat;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] com=new int[4];
        int su=0;
        boolean bCheck=false;
        for(int i=0;i<4;i++)
        {
        	bCheck=true;
        	while(bCheck)
        	{
        		su=(int)(Math.random()*4)+1;
        		bCheck=false;
        		for(int j=0;j<i;j++)
        		{
        			if(com[j]==su)
        			{
        				bCheck=true;
        				break;
        			}
        		}
        	}
        	com[i]=su;
        }
        
        for(int i=0;i<4;i++)
        {
        	System.out.print(com[i]+" ");
        }
	}

}
