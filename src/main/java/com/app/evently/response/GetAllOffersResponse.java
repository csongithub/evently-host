/**
 * 
 */
package com.app.evently.response;

import java.util.List;

import com.app.evently.infra.BaseResponse;
import com.app.evently.model.Offer;

/**
 * @author chasisin
 *
 */
public class GetAllOffersResponse extends BaseResponse {
	
	List<Offer> offers;

	/**
	 * @return the offers
	 */
	public List<Offer> getOffers() {
		return offers;
	}

	/**
	 * @param offers the offers to set
	 */
	public void setOffers(List<Offer> offers) {
		this.offers = offers;
	}

}
