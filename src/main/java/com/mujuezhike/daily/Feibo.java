package com.mujuezhike.daily;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class Feibo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fibonacci(BigInteger.valueOf(36)));
		System.out.println(fibonacciZ(BigInteger.valueOf(36)));
	
	}
	
	//private static BigInteger u = null;
	 // 递归实现方式  
    public static BigInteger fibonacci(BigInteger n){  
    	BigInteger u = null;
        if(n.compareTo(BigInteger.valueOf(2))<=0){  
            return BigInteger.valueOf(1);  
        }else{  
        	u = fibonacci(n.add(BigInteger.valueOf(-1))).add(fibonacci(n.add(BigInteger.valueOf(-2))));
            return u;  
        }  
    }  

    // 递归实现方式  phi
    public static BigInteger fibonacciZ(BigInteger n){

    	BigDecimal bi = (BigDecimal.valueOf(1.0/0.6180339887498948482045868343).pow(n.intValue())).divide(BigDecimal.valueOf(Math.sqrt(5)),59,RoundingMode.HALF_UP);
		
		return bi.toBigInteger();
		
    	
    }
    
}
