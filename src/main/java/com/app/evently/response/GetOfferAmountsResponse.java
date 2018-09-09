/**
 * 
 */
package com.app.evently.response;

import com.app.evently.infra.BaseResponse;

/**
 * @author chasisin
 *
 */
public class GetOfferAmountsResponse extends BaseResponse {
	private Double purchageAmount;
	private Double offerAmount;
	/**
	 * @return the purchageAmount
	 */
	public Double getPurchageAmount() {
		return purchageAmount;
	}
	/**
	 * @param purchageAmount the purchageAmount to set
	 */
	public void setPurchageAmount(Double purchageAmount) {
		this.purchageAmount = purchageAmount;
	}
	/**
	 * @return the offerAmount
	 */
	public Double getOfferAmount() {
		return offerAmount;
	}
	/**
	 * @param offerAmount the offerAmount to set
	 */
	public void setOfferAmount(Double offerAmount) {
		this.offerAmount = offerAmount;
	}
}
