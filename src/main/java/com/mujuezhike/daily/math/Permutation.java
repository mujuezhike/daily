package com.mujuezhike.daily.math;

public class Permutation {
	 static int a[] = new int[100];    
	    public static void f(int n,int r){  
	        if(r == 1){  
	            a[r-1] = n;  
	            int j = 0;  
	            while(a[j]!= 0){  
	                j++;  
	            }  
	            for(int i = j-1; i >= 0; i --){  
	                System.out.print(a[i]+",");  
	            }  
	            System.out.println();  
	        }  
	        else{  
	            a[r-1] = n;  
	            for(int j = n-1; j >= r-1; j --){              
	                f(j,r-1);  
	            }     
	        }  
	    }  
	    public static void main(String[] args) {  
	        int n = 8,r = 7;  
	        for(int i = n; i >= r; i --){  
	            f(i,r);  
	        }         
	    }  
}
