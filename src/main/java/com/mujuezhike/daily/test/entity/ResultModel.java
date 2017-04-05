package com.mujuezhike.daily.test.entity;

import java.util.List;

import com.mujuezhike.daily.test.enums.ResultStatus;

public class ResultModel {

	/**
     * 返回码
     */
    private int code;

    /**
     * 返回结果描述
     */
    private String message;

    /**
     * 返回内容
     */
    private Object content;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Object getContent() {
        return content;
    }

    public ResultModel(int code, String message) {
        this.code = code;
        this.message = message;
        this.content = "";
    }

    public ResultModel(int code, String message, Object content) {
        this.code = code;
        this.message = message;
        this.content = content;
    }

    public ResultModel(ResultStatus status) {
        this.code = status.getCode();
        this.message = status.getMessage();
        this.content = "";
    }
    
    public ResultModel(ResultStatus status, Object content) {
        this.code = status.getCode();
        this.message = status.getMessage();
        this.content = content;
    }

    public static ResultModel ok(Object content) {
        return new ResultModel(ResultStatus.SUCCESS, content);
    }
    
    public static ResultModel ok(String msg) {
        return new ResultModel(ResultStatus.SUCCESS, msg);
    }

    /**
     * 针对Easyui包装结果集
     * @param <T>
     * @param content 数据信息
     * @param pagecount 总页数
     * @return
     */
    public static <T> ResultModel ok(List<T> content, int pagecount) {
    	EasyUIWraper<T> result = new EasyUIWraper<T>();
		result.setTotal(pagecount);
		result.setRows(content);
        return new ResultModel(ResultStatus.SUCCESS, result);
    }


    public static ResultModel ok() {
        return new ResultModel(ResultStatus.SUCCESS);
    }

    public static ResultModel error(ResultStatus error) {
        return new ResultModel(error);
    }
}
