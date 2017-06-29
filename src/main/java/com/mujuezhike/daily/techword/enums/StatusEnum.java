package com.mujuezhike.daily.techword.enums;

public enum StatusEnum {

	/**
	 * 状态：正常
	 */
	NORMAL            (1,"正常"), 
	/**
	 * 状态：删除
	 */
	DELETE            (0,"删除"),
	;
	
	/**
	 * 状态号
	 */
	private Integer num;
	
	/**
	 * 状态
	 */
	private String describe;
	
	private StatusEnum(Integer num, String describe){
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
	public static StatusEnum getByErrorCode(Integer innum){
		StatusEnum[] enums = values();
		for(StatusEnum e:enums){
			if(e.num.equals(innum)){
				return e;
			}
		}
 		return null;
	}
	
}
