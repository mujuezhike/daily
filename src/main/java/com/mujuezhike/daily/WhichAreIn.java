package com.mujuezhike.daily;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WhichAreIn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static String[] inArray(String[] array1, String[] array2) {
		 
		List<String> arr = new ArrayList<String>();
		Map<String,Integer> has = new HashMap<String,Integer>();
	    
		StringBuffer su = new StringBuffer();
		
	    for(int i=0;i<array2.length;i++){
	    	
	    	su.append("|");
	    	su.append(array2[i]);
	    	
	    }
	    
	    for(int i=0;i<array1.length;i++){
	    	
	    	if(su.indexOf(array1[i])>-1){
	    		Integer ie = has.get(array1[i]);
	    		if(ie!=null){
	    			
	    		}else{
	    			arr.add(array1[i]);
	    			has.put(array1[i], 1);
	    		}
	    		
	    	}
	    	
	    }
	    
	    Collections.sort(arr);
	    
	    String[] rarray = new String[arr.size()];
	    
	    for(int i=0;i<arr.size();i++){
	    	
	    	rarray[i] = arr.get(i);
	    }
	    
	    
	    return rarray;
	}
}
