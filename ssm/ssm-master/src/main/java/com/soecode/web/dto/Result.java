package com.soecode.web.dto;

import java.io.Serializable;

/**
 * 封装json对象，所有返回结果都使用它
 */
public class Result<T> implements Serializable {
	private static final long serialVersionUID = -4663953438128942186L;
	private boolean isSuccess;
	private String msg;
	private T model;

	public void setSuccess(T t) {
		setSuccess(true);
		setModel(t);
	}

	public void setFailed(String msg) {
		setSuccess(false);
		setMsg(msg);
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getModel() {
		return model;
	}

	public void setModel(T model) {
		this.model = model;
	}
}
