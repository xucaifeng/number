package com.cenozoic.number.constant;

/**
 *
 * @Desc
 *
 * @author xucaifeng
 * @date 2020-12-19
 */
public class Constant {

    /**
	 * 响应状态
	 * @author
	 * @date 2020年12月19日
	 */
	public enum RespStatus {
		/**
		 * 成功
		 */
		SUCCESS(0),
		/**
		 * 失败
		 */
		FAIL(1),
		/**
		 * 未登陆
		 */
		LOGOUT(7),
		/**
		 * 接口出错
 		 */
		ERROR(4),
		/**
		 * 次数超限
		 */
		FAIL_LIMIT(5);

		private Integer code;

		public Integer getCode() {
			return code;
		}

		public void setCode(Integer code) {
			this.code = code;
		}

		RespStatus(Integer code) {
			this.code = code;
		}
	}



	public static Integer success = Integer.valueOf(0);
}
