/**
 * 
 */
package com.app.evently.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.evently.infra.AbstractController;
import com.app.evently.infra.TransactionStatus;
import com.app.evently.model.Offer;
import com.app.evently.response.GetAllOffersResponse;
import com.app.evently.response.GetOfferAmountsResponse;
import com.app.evently.response.GetOfferByNameResponse;
import com.app.evently.response.GetOffferByIdResponse;
import com.app.evently.service.OfferService;

/**
 * @author chasisin
 *
 */
@RestController
@RequestMapping(value = "/OfferRestController") 
public class OfferRestController extends AbstractController{
	private static Logger logger = Logger.getLogger(OfferRestController.class);
	private OfferService offerService;
	
	public OfferRestController(OfferService offerService) {
		this.offerService = offerService;
	}	
	
	@RequestMapping(method = RequestMethod.POST, value = "/createOffer")
	public TransactionStatus createOffer(@RequestBody Offer offer) {
		TransactionStatus status = fetchTransactionStatus();
		try {
			status = this.offerService.createOffer(offer);
		}catch(Throwable e) {
			logger.error("Error in createOffer",e);
			fillTransactionStatus(status, e);
		}
		return status;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/getAllOffers")
	public GetAllOffersResponse getAllOffers(){
		GetAllOffersResponse response = new GetAllOffersResponse();
		try {
			response = this.offerService.getAllOffers();
		}catch(Throwable e) {
			logger.error("Error in getAllOffers",e);
			fillTransactionStatus(response, e);
		}
		return response;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "getOfferById/{offerId}")
	public GetOffferByIdResponse getOfferById(@PathVariable String offerId) {
		GetOffferByIdResponse response = new GetOffferByIdResponse();
		try {
			response = this.offerService.getOfferById(offerId);
		}catch(Throwable e) {
			logger.error("Error in createOffer",e);
			fillTransactionStatus(response, e);
		}
		return response;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/getOfferByName/{offerName}")
	public GetOfferByNameResponse getOfferByName(@PathVariable String offerName) {
		GetOfferByNameResponse response = new GetOfferByNameResponse();
		try {
			response = this.offerService.getOfferByName(offerName);
		}catch(Throwable e) {
			logger.error("Error in getOfferByName",e);
			fillTransactionStatus(response, e);
		}
		return response;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "getOfferBasicDetails/{offerId}")
	public GetOfferAmountsResponse getOfferAmounts(@PathVariable String offerId) {
		GetOfferAmountsResponse response = new GetOfferAmountsResponse();
		try {
			response = this.offerService.getOfferAmounts(offerId);
		}catch(Throwable e) {
			logger.error("Error in getOfferAmounts",e);
			fillTransactionStatus(response, e);
		}
		return response; 
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/updateOfferAmount/{offerId}/{offerAmount}")
	public TransactionStatus updateOfferAmount(@PathVariable String offerId, @PathVariable Double offerAmount) {
		TransactionStatus status = fetchTransactionStatus();
		try {
			status = this.offerService.updateOfferAmount(offerId, offerAmount);
		}catch(Throwable e) {
			logger.error("Error in updateOfferAmount",e);
			fillTransactionStatus(status, e);
		}
		return status;
	}
}
