/**
 * 
 */
package com.app.evently.response;

import com.app.evently.infra.BaseResponse;
import com.app.evently.model.Offer;

/**
 * @author chasisin
 *
 */
public class GetOfferByNameResponse extends BaseResponse {
	
	private Offer offer;

	/**
	 * @return the offer
	 */
	public Offer getOffer() {
		return offer;
	}

	/**
	 * @param offer the offer to set
	 */
	public void setOffer(Offer offer) {
		this.offer = offer;
	}
}
