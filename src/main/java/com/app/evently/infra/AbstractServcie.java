/**
 * 
 */
package com.app.evently.infra;

/**
 * @author chasisin
 *
 */
public abstract class AbstractServcie extends AbstractServiceController{
	
	protected void fillTransactionStatus(TransactionStatus status) {
		status = fetchTransactionStatus();
	}
	
	protected void fillTransactionStatus(BaseResponse response) {
		if(response.getStatus() == null) {
			TransactionStatus status = new TransactionStatus();
			status.setErrorCode(TransactionStatus.SUSSCESS_ERR_CODE);
			status.setMessage(TransactionStatus.SUCCESS_MSG);
			response.setStatus(status);
		}else {
			response.setStatus(fetchTransactionStatus());
		}
	}
}
