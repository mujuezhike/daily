package com.mujuezhike.daily.card;

public enum CardEnums{

	;

	/**
	 * 返回码
	 */
	private int code;

	/**
	 * 返回结果描述
	 */
	private String message;

	CardEnums(int code, String message) {
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
