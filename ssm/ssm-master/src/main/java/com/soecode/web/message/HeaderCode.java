package com.soecode.web.message;

public interface HeaderCode {
	/**
	 * 消息头代码标识 ClassName: RespCode
	 * 
	 * @Description: TODO
	 *               <p>
	 * 				Title: HeaderCode.java
	 *               </p>
	 * @author: 戴志锋
	 * @version V1.0
	 * @see Class
	 * @since JDK{jdk1.6}
	 */
	public enum RespCode {
		SUCCESS("0000000"), // 成功
		FAIL("9999990");// 失败
		String code;

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		private RespCode(String code) {
			this.code = code;
		}
	}

	/**
	 *
	 * ClassName: ContentEnum
	 *
	 * @Description: TODO
	 *               <p>
	 * 				Title: HeaderCode.java
	 *               </p>
	 * @author: 戴志锋
	 * @version V1.0
	 * @see Class
	 * @since JDK{jdk1.6}
	 */
	public enum RespContent {
		TimeoutContent("9000000"), // 登陆超时失效
		FailShowContent("9000001"), // 显示给前端使用人员
		FailTipContent("9000002");// 显示给开发人员
		String code;
		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}
		private RespContent(String code) {
			this.code = code;
		}
	}
}
