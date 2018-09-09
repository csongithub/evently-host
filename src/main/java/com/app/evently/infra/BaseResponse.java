/**
 * 
 */
package com.app.evently.infra;

/**
 * @author chasisin
 *
 */
public class BaseResponse {
	private TransactionStatus status;
	/**
	 * @return the status
	 */
	public TransactionStatus getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(TransactionStatus status) {
		this.status = status;
	}
}
