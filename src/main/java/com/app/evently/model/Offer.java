/**
 * 
 */
package com.app.evently.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author chasisin
 *
 */
@Document(collection = "evently_offer")
public class Offer implements IOffer{
	
	@Id
	String offerId;
	String offerName;
	@Indexed(direction = IndexDirection.ASCENDING)
	Double purchageAmount;
	Double offerAmount;
	/**
	 * 
	 */
	public Offer() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param offerId
	 * @param offerName
	 * @param purchageAmount
	 * @param offerAmount
	 */
	public Offer(String offerId, String offerName, Double purchageAmount, Double offerAmount) {
		super();
		this.offerId = offerId;
		this.offerName = offerName;
		this.purchageAmount = purchageAmount;
		this.offerAmount = offerAmount;
	}
	/**
	 * @return the offerId
	 */
	public String getOfferId() {
		return offerId;
	}
	/**
	 * @param offerId the offerId to set
	 */
	public void setOfferId(String offerId) {
		this.offerId = offerId;
	}
	/**
	 * @return the offerName
	 */
	public String getOfferName() {
		return offerName;
	}
	/**
	 * @param offerName the offerName to set
	 */
	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}
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
