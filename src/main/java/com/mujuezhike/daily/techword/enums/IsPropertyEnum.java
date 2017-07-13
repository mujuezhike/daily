package com.mujuezhike.daily.techword.enums;

public enum IsPropertyEnum {
	
	/**
	 * 是
	 */
	Is            (1,"是"), 
	/**
	 * 否
	 */
	IsNot            (0,"否"),
	;
	
	/**
	 * 状态号
	 */
	private Integer num;
	
	/**
	 * 状态
	 */
	private String describe;
	
	private IsPropertyEnum(Integer num, String describe){
		this.num = num;
		this.describe = describe;
	}
	
	public Integer num(){
		return num;
	}
	
	public String describe(){
		return describe;
	}
	
	/** 根据innum 获取enum对象  **/
	public static IsPropertyEnum getByErrorCode(Integer innum){
		IsPropertyEnum[] enums = values();
		for(IsPropertyEnum e:enums){
			if(e.num.equals(innum)){
				return e;
			}
		}
 		return null;
	}

}
