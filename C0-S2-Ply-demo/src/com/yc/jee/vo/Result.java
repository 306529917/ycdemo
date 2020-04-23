package com.yc.jee.vo;

import com.google.gson.Gson;

public class Result {
	
	private static Gson gson = new Gson();

	private int code;
	private String msg;
	private Object data;
	
	public static final Result SUCCESS = new Result(1, null, null);
	public static final Result FAILURE = new Result(0, null, null);

	public Result(int code, String msg, Object data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public Result(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Result(int code) {
		this.code = code;
	}
	
	public static Result failure(String msg, Object data) {
		return new Result(0, msg, data);
	}

	public static Result success(String msg, Object data) {
		return new Result(1, msg, data);
	}

	public static Result failure(String msg) {
		return new Result(0, msg, null);
	}

	public static Result success(String msg) {
		return new Result(1, msg, null);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String toString() {
		return gson.toJson(this);
	}
}
