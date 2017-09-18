package com.mujuezhike.daily.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class FileToString {

	public static void main(String[] args) throws IOException {
		
		 //StringBuffer sb= new StringBuffer("");
         
        InputStreamReader reader=new InputStreamReader(new FileInputStream("c://data//e_company.txt"),"UNICODE");
        BufferedReader br = new BufferedReader(reader);
        
         String str = null;
        
         File file = new File("c://data//e_companyss.txt");
		 OutputStream o = new FileOutputStream(file);
		
         while((str = br.readLine()) != null) {
               
        	 str = str.substring(str.indexOf("	")+1);
        	 
        	   o.write((",\""+str+"\"").getBytes());
			   o.write("\r\n".getBytes());
        	 
        	   
        	 	
               System.out.println(",\""+str+"\"");
               
         }
         
         

	}

}
