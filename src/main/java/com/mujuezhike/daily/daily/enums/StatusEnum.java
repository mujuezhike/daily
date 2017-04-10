package com.mujuezhike.daily.daily.enums;

public enum StatusEnum{
	
	NORMAL(1, "正常")						,//正常
	DELETED(0, "无效")					,//删除的
	;
	
	/**
	 * 返回码
	 */
	private int code;

	/**
	 * 返回结果描述
	 */
	private String message;

	StatusEnum(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
