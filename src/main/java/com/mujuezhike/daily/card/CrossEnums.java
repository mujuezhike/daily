package com.mujuezhike.daily.card;

public enum CrossEnums {

	VOID_X_VOID            (0,0,"75%虚空  25%元素",                   		new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,4,5}),
	VOID_X_WATER           (0,1,"50%虚空  40%特定元素  5%光明 5%黑暗",		    new int[]{0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,7,8}),
	VOID_X_FIRE            (0,2,"50%虚空  40%特定元素  5%光明 5%黑暗",		    new int[]{0,0,0,0,0,0,0,0,0,0,2,2,2,2,2,2,2,2,7,8}),
	VOID_X_EARTH           (0,3,"50%虚空  40%特定元素  5%光明 5%黑暗",		    new int[]{0,0,0,0,0,0,0,0,0,0,3,3,3,3,3,3,3,3,7,8}),
	VOID_X_TREE            (0,4,"50%虚空  40%特定元素  5%光明 5%黑暗",		    new int[]{0,0,0,0,0,0,0,0,0,0,4,4,4,4,4,4,4,4,7,8}),
	VOID_X_WIND            (0,5,"50%虚空  40%特定元素  5%光明 5%黑暗",		    new int[]{0,0,0,0,0,0,0,0,0,0,5,5,5,5,5,5,5,5,7,8}),
	VOID_X_METAL           (0,6,"40%虚空  50%元素 10%金属",            		new int[]{0,0,0,0,1,2,3,4,5,6}),
	VOID_X_LIGHT           (0,7,"30%虚空  50%元素 20%光明",            		new int[]{0,0,0,1,2,3,4,5,7,7}),
	VOID_X_DARK            (0,8,"30%虚空  50%元素 20%黑暗",            		new int[]{0,0,0,1,2,3,4,5,8,8}),
	VOID_X_CHAOS           (0,9,"40%虚空  30%光明 30%黑暗",            		new int[]{0,0,0,0,7,7,7,8,8,8}),
	
	WATER_X_WATER          (1,1,"10%虚空  80%特定元素  10%金属",        		new int[]{0,1,1,1,1,1,1,1,1,6}),
	WATER_X_FIRE           (1,2,"30%虚空  30%特定元素1 30%特定元素2 10%金属", new int[]{0,0,0,1,1,1,2,2,2,6}),
	WATER_X_EARTH          (1,3,"30%虚空  30%特定元素1 30%特定元素2 10%金属", new int[]{0,0,0,1,1,1,3,3,3,6}),
	WATER_X_TREE           (1,4,"30%虚空  30%特定元素1 30%特定元素2 10%金属", new int[]{0,0,0,1,1,1,4,4,4,6}),
	WATER_X_WIND           (1,5,"30%虚空  30%特定元素1 30%特定元素2 10%金属", new int[]{0,0,0,1,1,1,5,5,5,6}),
	WATER_X_METAL          (1,6,"70%特定元素  10%光明 10%黑暗 10%金属",        new int[]{1,1,1,1,1,1,1,6,7,8}),
	WATER_X_LIGHT          (1,7,"70%特定元素  10%光明 10%黑暗 10%金属",        new int[]{1,1,1,1,1,1,1,6,7,8}),
	WATER_X_DARK           (1,8,"70%特定元素  10%光明 10%黑暗 10%金属",        new int[]{1,1,1,1,1,1,1,6,7,8}),
	WATER_X_CHAOS          (1,9,"60%特定元素  40%其他元素",                   new int[]{1,1,1,1,1,1,2,3,4,5}),
	
	FIRE_X_FIRE            (2,2,"10%虚空  80%特定元素  10%金属",        		new int[]{0,2,2,2,2,2,2,2,2,6}),
	FIRE_X_EARTH           (2,3,"30%虚空  30%特定元素1 30%特定元素2 10%金属", new int[]{0,0,0,2,2,2,3,3,3,6}),
	FIRE_X_TREE            (2,4,"30%虚空  30%特定元素1 30%特定元素2 10%金属", new int[]{0,0,0,2,2,2,4,4,4,6}),
	FIRE_X_WIND            (2,5,"30%虚空  30%特定元素1 30%特定元素2 10%金属", new int[]{0,0,0,2,2,2,5,5,5,6}),
	FIRE_X_METAL           (2,6,"70%特定元素  10%光明 10%黑暗 10%金属",        new int[]{2,2,2,2,2,2,2,6,7,8}),
	FIRE_X_LIGHT           (2,7,"70%特定元素  10%光明 10%黑暗 10%金属",        new int[]{2,2,2,2,2,2,2,6,7,8}),
	FIRE_X_DARK            (2,8,"70%特定元素  10%光明 10%黑暗 10%金属",        new int[]{2,2,2,2,2,2,2,6,7,8}),
	FIRE_X_CHAOS           (2,9,"60%特定元素  40%其他元素",                   new int[]{2,2,2,2,2,2,1,3,4,5}),
	
	EARTH_X_EARTH          (3,3,"10%虚空  80%特定元素  10%金属",        		new int[]{0,3,3,3,3,3,3,3,3,6}),
	EARTH_X_TREE           (3,4,"30%虚空  30%特定元素1 30%特定元素2 10%金属", new int[]{0,0,0,3,3,3,4,4,4,6}),
	EARTH_X_WIND           (3,5,"30%虚空  30%特定元素1 30%特定元素2 10%金属", new int[]{0,0,0,3,3,3,5,5,5,6}),
	EARTH_X_METAL          (3,6,"70%特定元素  10%光明 10%黑暗 10%金属",        new int[]{3,3,3,3,3,3,3,6,7,8}),
	EARTH_X_LIGHT          (3,7,"70%特定元素  10%光明 10%黑暗 10%金属",        new int[]{3,3,3,3,3,3,3,6,7,8}),
	EARTH_X_DARK           (3,8,"70%特定元素  10%光明 10%黑暗 10%金属",        new int[]{3,3,3,3,3,3,3,6,7,8}),
	EARTH_X_CHAOS          (3,9,"60%特定元素  40%其他元素",                   new int[]{3,3,3,3,3,3,1,2,4,5}),
	
	TREE_X_TREE            (4,4,"10%虚空  80%特定元素  10%金属",        		new int[]{0,4,4,4,4,4,4,4,4,6}),
	TREE_X_WIND            (4,5,"30%虚空  30%特定元素1 30%特定元素2 10%金属", new int[]{0,0,0,4,4,4,5,5,5,6}),
	TREE_X_METAL           (4,6,"70%特定元素  10%光明 10%黑暗 10%金属",        new int[]{4,4,4,4,4,4,4,6,7,8}),
	TREE_X_LIGHT           (4,7,"70%特定元素  10%光明 10%黑暗 10%金属",        new int[]{4,4,4,4,4,4,4,6,7,8}),
	TREE_X_DARK            (4,8,"70%特定元素  10%光明 10%黑暗 10%金属",        new int[]{4,4,4,4,4,4,4,6,7,8}),
	TREE_X_CHAOS           (4,9,"60%特定元素  40%其他元素",                   new int[]{4,4,4,4,4,4,1,2,3,5}),
	
	WIND_X_WIND            (5,5,"10%虚空  80%特定元素 10%金属",               new int[]{0,5,5,5,5,5,5,5,5,6}),
	WIND_X_METAL           (5,6,"70%特定元素  10%光明 10%黑暗 10%金属",        new int[]{5,5,5,5,5,5,5,6,7,8}),
	WIND_X_LIGHT           (5,7,"70%特定元素  10%光明 10%黑暗 10%金属",        new int[]{5,5,5,5,5,5,5,6,7,8}),
	WIND_X_DARK            (5,8,"70%特定元素  10%光明 10%黑暗 10%金属",        new int[]{5,5,5,5,5,5,5,6,7,8}),
	WIND_X_CHAOS           (5,9,"60%特定元素  40%其他元素",                   new int[]{5,5,5,5,5,5,1,2,3,4}),
	
	METAL_X_METAL          (6,6,"10%虚空  50%元素  40%金属",                   new int[]{0,1,2,3,4,5,6,6,6,6}),
	METAL_X_LIGHT          (6,7,"60%虚空  20%光明  20%金属",                   new int[]{0,0,0,0,0,0,6,6,7,7}),
	METAL_X_DARK           (6,8,"60%虚空  20%黑暗  20%金属",                   new int[]{0,0,0,0,0,0,6,6,8,8}),
	METAL_X_CHAOS          (6,9,"50%虚空  50%元素  ",                          new int[]{0,0,0,0,0,1,2,3,4,5}),
	
	LIGHT_X_LIGHT          (7,7,"60%虚空  40%光明  ",                          new int[]{0,0,0,0,0,0,7,7,7,7}),
	LIGHT_X_DARK           (7,8,"50%虚空  20%光明  20%黑暗 10%混沌",            new int[]{0,0,0,0,0,7,7,8,8,9}),
	LIGHT_X_CHAOS          (7,9,"50%虚空  50%元素  ",                          new int[]{0,0,0,0,0,1,2,3,4,5}),
	
	DARK_X_DARK            (8,8,"60%虚空  40%黑暗  ",                          new int[]{0,0,0,0,0,0,8,8,8,8}),
	DARK_X_CHAOS           (8,9,"50%虚空  50%元素  ",                          new int[]{0,0,0,0,0,1,2,3,4,5}),
	
	CHAOS_X_CHAOS          (9,9,"40%虚空  50%元素  10%混沌",                   new int[]{0,0,0,0,1,2,3,4,5,9}),
	;

	private int code1;
	private int code2;
	private String message;
	private int[] rcode;

	CrossEnums(int code1,int code2, String message,int[] rcode) {
		this.code1 = code1;
		this.code2 = code2;
		this.message = message;
		this.rcode = rcode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCode1() {
		return code1;
	}

	public void setCode1(int code1) {
		this.code1 = code1;
	}

	public int getCode2() {
		return code2;
	}

	public void setCode2(int code2) {
		this.code2 = code2;
	}

	public int[] getRcode() {
		return rcode;
	}

	public void setRcode(int[] rcode) {
		this.rcode = rcode;
	}
	
	public static CrossEnums findByCode(int code1,int code2){
		
		int codef1 = 0;
		int codef2 = 0;
		
		if(code1>code2){
			
			codef1 = code2;
			codef2 = code1;
			
		}else{
			
			codef1 = code1;
			codef2 = code2;
			
		}
		
		CrossEnums[] crosses = values();
		for(int i=0;i<crosses.length;i++){	
			
			if(crosses[i].getCode1() == codef1 
					&& crosses[i].getCode2() == codef2){
				
				return crosses[i];
				
			}
			
		}
		
		return null;
		
	}
}
