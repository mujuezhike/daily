package com.mujuezhike.daily.techword.enums;

public enum OPTypeEnum {
	
	/**
	 * 新增
	 */
	ADD            (1,"新增"), 
	/**
	 * 编辑
	 */
	EDIT            (0,"编辑"),
	;
	
	/**
	 * 状态号
	 */
	private Integer num;
	
	/**
	 * 状态
	 */
	private String describe;
	
	private OPTypeEnum(Integer num, String describe){
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
	public static OPTypeEnum getByErrorCode(Integer innum){
		OPTypeEnum[] enums = values();
		for(OPTypeEnum e:enums){
			if(e.num.equals(innum)){
				return e;
			}
		}
 		return null;
	}

}
