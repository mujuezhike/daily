package com.mujuezhike.daily.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutate {
	
	public static int total = 0;  
    
	public static int artotal = 0;  
	
	public static void swap(String[] str, int i, int j)  
    {  
        String temp = new String();  
        temp = str[i];  
        str[i] = str[j];  
        str[j] = temp;  
    }
	
	public static void arswap(Integer[] str, int i, int j)  
    {  
		Integer temp = new Integer(0);  
        temp = str[i];  
        str[i] = str[j];  
        str[j] = temp;  
    }  
	
    public static void arrange (String[] str, int st, int len)  
    {  
        if (st == len - 1)  
        {  
            for (int i = 0; i < len; i ++)  
            {  
                System.out.print(str[i]+ "  ");  
            }  
            System.out.println();  
            total++;  
        }  
        else  
        {  
            for (int i = st; i < len; i ++)  
            {  
                swap(str, st, i);  
                arrange(str, st + 1, len);  
                swap(str, st, i);  
            }  
        }  
          
    }  
    
    public static void arrange (Integer[] ar, int st, int len , List<List<Integer>> list)  
    {  
        if (st == len - 1)  
        {  
            List<Integer> mlist = new ArrayList<Integer>();
        	List<Integer> li = Arrays.asList(ar);
        	mlist.addAll(li);
        	list.add(mlist);
        	
        	for(int ej=0;ej<mlist.size();ej++){
        		System.out.print(mlist.get(ej));
        	}
        	System.out.println();
        	
        	artotal++;  
        }  
        else  
        {  
            for (int i = st; i < len; i ++)  
            {  
                arswap(ar, st, i);  
                arrange(ar, st + 1, len,list);  
                arswap(ar, st, i);  
            }  
        }  
          
    }  
    
    /** 
     * @param args 
     */  
    public static void main(String[] args) {  
        // TODO Auto-generated method stub  
         String str[] = {"a","b","c","d","e","f","g","h","i","j"};  
         arrange(str, 0, str.length);  
         System.out.println(total);  
    }  
    
    public static List<List<Integer>> generatelist(Integer i){
		
    	Integer[] ar = new Integer[i];
    	for(int j=0 ;j<ar.length ;j++){
    		ar[j] = j+1;
    	}
    	
    	List<List<Integer>> ilist = new ArrayList<List<Integer>>();
    	
    	arrange(ar, 0, ar.length,ilist);
    	
    	return ilist;
    	
    }

}
