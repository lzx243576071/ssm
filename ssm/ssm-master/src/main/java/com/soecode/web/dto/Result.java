package com.soecode.web.dto;


import com.alibaba.fastjson.JSON;

import java.io.Serializable;

public class Result<T> implements Serializable {
	private static final long serialVersionUID = 5616070434977448606L;
	private boolean success;
	private String resultCode;
	private String msg;
	private T data;
	public long startTime;
	public long timeConsum;
	private static final String HOSTNAME = (String)System.getenv().get("COMPUTERNAME");

	public static <W> Result<W> createFailResult() {
		Result<W> ret = new Result();
		ret.setResultCode(ResultCodeEnums.DEFAULT_ERROR.getCode());
		ret.setMsg(ResultCodeEnums.DEFAULT_ERROR.getMsg());
		ret.startTime = System.currentTimeMillis();
		return ret;
	}

	public static <W> Result<W> createFailResult(String msg) {
		Result<W> ret = new Result();
		ret.setSuccess(false);
		ret.setResultCode(ResultCodeEnums.DEFAULT_ERROR.getCode());
		ret.setMsg(msg);
		ret.startTime = System.currentTimeMillis();
		return ret;
	}

	public static <W> Result<W> createFailResult(ResultCodeEnums code) {
		Result<W> ret = new Result();
		ret.setSuccess(false);
		ret.setResultCode(code.getCode());
		ret.setMsg(code.getMsg());
		ret.startTime = System.currentTimeMillis();
		return ret;
	}

	public static <W> Result<W> createFailResult(Result result) {
		Result<W> ret = new Result();
		ret.setSuccess(false);
		ret.setResultCode(result.getResultCode());
		ret.setMsg(result.getMsg());
		ret.startTime = System.currentTimeMillis();
		return ret;
	}

	public Result() {
		this.resultCode = ResultCodeEnums.OK.getCode();
		this.startTime = -1L;
	}


	public static <W> Result<W> createSuccessResult() {
		Result<W> ret = new Result();
		ret.setSuccess(true);
		ret.setResultCode(ResultCodeEnums.OK.getCode());
		ret.setMsg(ResultCodeEnums.OK.getMsg());
		ret.startTime = System.currentTimeMillis();
		return ret;
	}

	//update by luzx 2019/07/14
	//可以传入list
//	public static <T> Result<T> createSuccessResult(T val) {
//		Result<T> ret = new Result<T>();
//		ret.setSuccess(true);
//		ret.setResultCode(ResultCodeEnums.OK.getCode());
//		ret.setMsg(ResultCodeEnums.OK.getMsg());
//		ret.value(val);
//
//		ret.startTime = System.currentTimeMillis();
//		ret.timeConsum = System.currentTimeMillis() - ret.startTime;
//
//		return ret;
//	}

	public static <T> Result<T> createSuccessResult(T val) {
		Result<T> ret = new Result();
		ret.setSuccess(true);
		ret.setResultCode(ResultCodeEnums.OK.getCode());
		ret.setMsg(ResultCodeEnums.OK.getMsg());
		ret.value(val);
		ret.startTime = System.currentTimeMillis();
		return ret;
	}

	public Result<T> value(T val) {
		if (val == null) {
			return this;
		} else {
			this.success = true;
			this.data = val;
			this.setMsg(ResultCodeEnums.OK.getMsg());
			this.setResultCode(ResultCodeEnums.OK.getCode());
			this.timeConsum = System.currentTimeMillis() - this.startTime;
			return this;
		}
	}

	public T value() {
		return this.data;
	}

	public T getData() {
		return this.data;
	}

	public void setData(T data) {
		this.data = data;
		this.timeConsum = System.currentTimeMillis() - this.startTime;
	}

	public boolean isSuccess() {
		return this.success;
	}

	private static String id() {
		return HOSTNAME + "-" + System.currentTimeMillis();
	}

	public String toString() {
		return ToStringHelper.create(this).add("success", this.success).add("msg", this.msg).add("resultCode", this.resultCode).add("data", this.data).toString();
	}

	public String getMsg() {
		return this.msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getResultCode() {
		return this.resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public static void main(String[] args) {
		Result<String> result = createSuccessResult();
		result.value("111");
		System.out.println(result.toString());
	}

	public void setSuccess(boolean success) {
		this.success = success;
		this.timeConsum = System.currentTimeMillis() - this.startTime;
	}

	public long getTimeConsum() {
		return this.timeConsum;
	}

	public void setTimeConsum(long timeConsum) {
		this.timeConsum = timeConsum;
	}

	/** @deprecated */
	@Deprecated
	public static Result<String> error() {
		Result<String> ret = new Result();
		ret.setResultCode(ResultCodeEnums.DEFAULT_ERROR.getCode());
		ret.setMsg(ResultCodeEnums.DEFAULT_ERROR.getMsg());
		return ret;
	}

	public static Result error(String msg) {
		Result ret = new Result();
		ret.setResultCode(ResultCodeEnums.ERROR.getCode());
		ret.setMsg(msg);
		return ret;
	}

	/** @deprecated */
	@Deprecated
	public static Result error(String code, String msg) {
		Result ret = new Result();
		ret.setResultCode(code);
		ret.setMsg(msg);
		return ret;
	}

	public static Result error(ResultCodeEnums code) {
		Result ret = new Result();
		ret.setResultCode(code.getCode());
		ret.setMsg(code.getMsg());
		return ret;
	}

	/** @deprecated */
	@Deprecated
	public static <W> Result<W> error(ResultCodeEnums code, W data) {
		Result<W> ret = error(code);
		ret.setData(data);
		return ret;
	}

	/** @deprecated */
	@Deprecated
	public static <W> Result<W> error(W data) {
		return error(ResultCodeEnums.ERROR, data);
	}

	/** @deprecated */
	@Deprecated
	public static <W> Result<W> error(String code, W data) {
		Result<W> ret = error(code);
		ret.setData(data);
		return ret;
	}

	/** @deprecated */
	@Deprecated
	public static <W> Result<W> error(String code, String msg, W data) {
		Result<W> ret = error(code, msg);
		ret.setData(data);
		return ret;
	}

	/** @deprecated */
	@Deprecated
	public static Result success() {
		Result ret = new Result();
		ret.setSuccess(true);
		ret.setResultCode(ResultCodeEnums.OK.getCode());
		ret.setMsg(ResultCodeEnums.OK.getMsg());
		ret.startTime = System.currentTimeMillis();
		return ret;
	}

	/** @deprecated */
	@Deprecated
	public static Result success(String msg) {
		Result ret = success();
		ret.setMsg(msg);
		return ret;
	}

	/** @deprecated */
	@Deprecated
	public static Result success(String code, String msg) {
		Result ret = success(msg);
		ret.setResultCode(code);
		return ret;
	}

	/** @deprecated */
	@Deprecated
	public static Result success(ResultCodeEnums code) {
		Result ret = success(code.getCode(), code.getMsg());
		return ret;
	}

	/** @deprecated */
	@Deprecated
	public static <W> Result<W> success(ResultCodeEnums code, W data) {
		Result ret = success(code);
		ret.setData(data);
		return ret;
	}

	/** @deprecated */
	@Deprecated
	public static <W> Result<W> success(W data) {
		Result ret = success();
		ret.setData(data);
		return ret;
	}

	/** @deprecated */
	@Deprecated
	public static <W> Result<W> success(String code, W data) {
		Result ret = success(code);
		ret.setData(data);
		return ret;
	}

	/** @deprecated */
	@Deprecated
	public static <W> Result<W> success(String code, String msg, W data) {
		Result ret = success(code, msg);
		ret.setData(data);
		return ret;
	}

	public String toJson() {
		return JSON.toJSONString(this);
	}
}
