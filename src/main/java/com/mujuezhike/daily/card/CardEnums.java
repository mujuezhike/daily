package com.mujuezhike.daily.card;

public enum CardEnums{

	VOID            (0,"虚空"),
	WATER           (1,"海水"),
	FIRE            (2,"火焰"),
	EARTH           (3,"大地"),
	TREE            (4,"森林"),
	WIND            (5,"暴风"),
	METAL           (6,"金属"),
	LIGHT           (7,"光明"),
	DARK            (8,"黑暗"),
	CHAOS           (9,"混沌"),
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
