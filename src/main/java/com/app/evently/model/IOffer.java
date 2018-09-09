/**
 * 
 */
package com.app.evently.model;

/**
 * @author chasisin
 *
 */
public interface IOffer {
	
	/**
	 * @return the offerId
	 */
	public String getOfferId();
	/**
	 * @param offerId the offerId to set
	 */
	public void setOfferId(String offerId);
	/**
	 * @return the offerName
	 */
	public String getOfferName();
	/**
	 * @param offerName the offerName to set
	 */
	public void setOfferName(String offerName);
	/**
	 * @return the purchageAmount
	 */
	public Double getPurchageAmount();
	/**
	 * @param purchageAmount the purchageAmount to set
	 */
	public void setPurchageAmount(Double purchageAmount);
	/**
	 * @return the offerAmount
	 */
	public Double getOfferAmount();
	/**
	 * @param offerAmount the offerAmount to set
	 */
	public void setOfferAmount(Double offerAmount);


}
