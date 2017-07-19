package com.mujuezhike.daily.pat;

import java.util.Scanner;

//不能使用  内存溢出
public class BattleOverCities {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
        String line = s.nextLine().trim();        
        
        String[] argees = line.split(" ");
        Integer numofcities = Integer.parseInt(argees[0]);
        Long numofhighways = Long.parseLong(argees[1]);
        
        String[] beans = null;
//        int city1 = 0;
//        int city2 = 0;
//        int cost = 0;
//        int islive = 0;
        while(line!=null && !line.equals("")){
        	line = s.nextLine();
//        	beans = line.split(" ");
//        	city1 = Integer.parseInt(beans[0]);
//        	city2 = Integer.parseInt(beans[1]);
//        	cost = Integer.parseInt(beans[2]);
//        	islive = Integer.parseInt(beans[3]);
        	System.out.println(line);
        }
        
	}

}
