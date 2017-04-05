package com.mujuezhike.daily.math;

import java.util.List;

public class GeneRate {

	public static void main(String[] args){
		
		System.out.println(System.nanoTime());
		List<List<Integer>> list = MathTest.generatelist(4);
		System.out.println(System.nanoTime());
		List<List<Integer>> alist = Permutate.generatelist(4);
		System.out.println(System.nanoTime());
//		
//		for (int i=0;i<list.size();i++){
//			
//			List<Integer> inlist = list.get(i);
//			
//			for(int j=0;j<inlist.size();j++){
//				
//				System.out.print(inlist.get(j) + "|");
//				
//			}
//			
//			System.out.println();
//		}
	}
	
}
