package com.mujuezhike.daily.daily.enums;

public enum ResultStatus {

	SUCCESS(100, "成功"),
	USERNAME_OR_PASSWORD_ERROR(-1001, "用户名或密码错误"),
	USER_NOT_FOUND(-1002,"用户不存在"),
	USER_NOT_LOGIN(-1003, "用户未登录"),
	
	//*************************商品**************************
	VALIDATION (6001,"数据不合法"),
	NO_FIND_Record(6002,"没有找到记录"),
	
	//*************************活动**************************
	UNKNOWN_ERROR(7003,"未知错误"),
	ENDSIGN(7004,"报名结束"),
	ENDPROMOTION(7005,"活动结束"),
	WEISHANGJIA(7006,"添加商品不在上架中状态"),
	YICANJIAHUODONG(7007,"商品正在活动中"),
	GUIZEERROR(7008,"商品不符合活动规则"),
	GOODSTATUSERROR(7010,"不是上架商品"),
	;

	/**
	 * 返回码
	 */
	private int code;

	/**
	 * 返回结果描述
	 */
	private String message;

	ResultStatus(int code, String message) {
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
