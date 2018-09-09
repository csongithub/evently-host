/**
 * 
 */
package com.app.evently.infra;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

/**
 * @author chasisin
 *
 */
public abstract class AbstractServiceController extends org.springframework.web.servlet.mvc.AbstractController{
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)throws Exception {
		return null;
	}
	
	protected TransactionStatus fetchTransactionStatus() {
		return new TransactionStatus();
	}
	
	protected void fillTransactionStatus(TransactionStatus status, Throwable e) {
		if(status == null) {
			status = fetchTransactionStatus();
		}
		status.setErrorCode(TransactionStatus.FAILURE_ERR_CODE);
		status.setMessage(e.getMessage());
	}
	
	protected void fillTransactionStatus(BaseResponse response, Throwable e) {
		if(response.getStatus() == null) {
			TransactionStatus status = new TransactionStatus();
			status.setErrorCode(TransactionStatus.FAILURE_ERR_CODE);
			status.setMessage(e.getMessage());
			response.setStatus(status);
		}else {
			response.getStatus().setErrorCode(TransactionStatus.FAILURE_ERR_CODE);
			response.getStatus().setMessage(e.getMessage());
		}	
	}
}
