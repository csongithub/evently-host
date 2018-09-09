/**
 * 
 */
package com.app.evently.infra;

/**
 * @author chasisin
 *
 */
public class TransactionStatus{
	
	public static final String SUSSCESS_ERR_CODE = "0";
	public static final String FAILURE_ERR_CODE = "-1";
	public static final String SUCCESS_MSG = "Operation Completed Successfully";
	public static final String FAILURE_MSG = "Operation Failed";
	
	private String errorCode = SUSSCESS_ERR_CODE;
	
	private String message = SUCCESS_MSG;

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}
