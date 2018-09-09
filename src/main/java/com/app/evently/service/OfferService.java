/**
 * 
 */
package com.app.evently.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.app.evently.infra.AbstractServcie;
import com.app.evently.infra.RepositoryConstant;
import com.app.evently.infra.RepositoryFactory;
import com.app.evently.infra.TransactionStatus;
import com.app.evently.model.Offer;
import com.app.evently.repository.OfferRepository;
import com.app.evently.response.GetAllOffersResponse;
import com.app.evently.response.GetOfferAmountsResponse;
import com.app.evently.response.GetOfferByNameResponse;
import com.app.evently.response.GetOffferByIdResponse;

/**
 * @author chasisin
 *
 */
@Service
public class OfferService extends AbstractServcie{
	private static final String THIS_COMPONENT_NAME = OfferService.class.getName();
	private static Logger logger = Logger.getLogger(OfferService.class);
	private OfferRepository repository = null;
	
	public OfferService() {
		
	}
	
	public TransactionStatus createOffer(Offer offer) {
		logger.info("Entering "+ "com.demo.mongodb.springdata.service.OfferService.createOffer");
		TransactionStatus status = fetchTransactionStatus();
		try {
			repository =(OfferRepository)RepositoryFactory.getRepository(RepositoryConstant.OFFER_REPOSITORY);
			repository.createOffer(offer);
			fillTransactionStatus(status);
		}catch(RuntimeException e) {
			logger.error("Error in com.demo.mongodb.springdata.service.OfferService.createOffer",e);
			fillTransactionStatus(status, e);
		}catch(Throwable e) {
			logger.error("Error in com.demo.mongodb.springdata.service.OfferService.createOffer",e);
			fillTransactionStatus(status, e);
		}finally {
			logger.info("Exiting "+ "com.demo.mongodb.springdata.service.OfferService.createOffer");
		}
		return status;
	}

	public GetAllOffersResponse getAllOffers() {
		logger.info("Entering "+ "com.demo.mongodb.springdata.service.OfferService.getAllOffers");
		GetAllOffersResponse response = new GetAllOffersResponse();
		try {
			repository =(OfferRepository)RepositoryFactory.getRepository(RepositoryConstant.OFFER_REPOSITORY);
			List<Offer> offers =  repository.getAllOffers();
			response.setOffers(offers);
			fillTransactionStatus(response);
		}catch(RuntimeException e) {
			logger.error("Error in com.demo.mongodb.springdata.service.OfferService.getAllOffers",e);
			fillTransactionStatus(response, e);
		}catch(Throwable e) {
			logger.error("Error in com.demo.mongodb.springdata.service.OfferService.getAllOffers",e);
			fillTransactionStatus(response, e);
		}finally {
			logger.info("Exiting "+ "com.demo.mongodb.springdata.service.OfferService.getAllOffers");
		}
		return response;
	}

	public GetOffferByIdResponse getOfferById(String offerId) {
		logger.info("Entering "+ "com.demo.mongodb.springdata.service.OfferService.getOfferById");
		GetOffferByIdResponse response = new GetOffferByIdResponse();
		try {
			repository =(OfferRepository)RepositoryFactory.getRepository(RepositoryConstant.OFFER_REPOSITORY);
			Offer offer = repository.getOfferById(offerId);
			response.setOffer(offer);
			fillTransactionStatus(response);
		}catch(RuntimeException e) {
			logger.error("Error in com.demo.mongodb.springdata.service.OfferService.getOfferById",e);
			fillTransactionStatus(response, e);
		}catch(Throwable e) {
			logger.error("Error in com.demo.mongodb.springdata.service.OfferService.getOfferById",e);
			fillTransactionStatus(response, e);
		}finally {
			logger.info("Exiting "+ "com.demo.mongodb.springdata.service.OfferService.getOfferById");
		}
		return response;
	}

	public GetOfferByNameResponse getOfferByName(String offerName) {
		logger.info("Entering "+ "com.demo.mongodb.springdata.service.OfferService.getOfferByName");
		GetOfferByNameResponse response = new GetOfferByNameResponse();
		try {
			repository =(OfferRepository)RepositoryFactory.getRepository(RepositoryConstant.OFFER_REPOSITORY);
			Offer offer = repository.getOfferByName(offerName);
			response.setOffer(offer);
			fillTransactionStatus(response);
		}catch(RuntimeException e) {
			logger.error("Error in com.demo.mongodb.springdata.service.OfferService.getOfferByName",e);
			fillTransactionStatus(response, e);
		}catch(Throwable e) {
			logger.error("Error in com.demo.mongodb.springdata.service.OfferService.getOfferByName",e);
			fillTransactionStatus(response, e);
		}finally {
			logger.info("Exiting "+ "com.demo.mongodb.springdata.service.OfferService.getOfferByName");
		}
		return response;
	}
	
	public GetOfferAmountsResponse getOfferAmounts(String offerId) {
		logger.info("Entering "+ "com.demo.mongodb.springdata.service.OfferService.getOfferAmounts");
		GetOfferAmountsResponse response = new GetOfferAmountsResponse();
		try {
			repository =(OfferRepository)RepositoryFactory.getRepository(RepositoryConstant.OFFER_REPOSITORY);
			Offer offer = repository.getOfferAmounts(offerId);
			if(offer != null) {
				response.setPurchageAmount(offer.getPurchageAmount());
				response.setOfferAmount(offer.getOfferAmount());
			}
			fillTransactionStatus(response);
		}catch(RuntimeException e) {
			logger.error("Error in com.demo.mongodb.springdata.service.OfferService.getOfferAmounts",e);
			fillTransactionStatus(response, e);
		}catch(Throwable e) {
			logger.error("Error in com.demo.mongodb.springdata.service.OfferService.getOfferAmounts",e);
			fillTransactionStatus(response, e);
		}finally {
			logger.info("Exiting "+ "com.demo.mongodb.springdata.service.OfferService.getOfferAmounts");
		}
		return response;
	}
	
	public TransactionStatus updateOfferAmount(String offerId, Double offerAmount) {
		logger.info("Entering "+ "com.demo.mongodb.springdata.service.OfferService.updateOfferAmount");
		TransactionStatus status = fetchTransactionStatus();
		try {
			repository =(OfferRepository)RepositoryFactory.getRepository(RepositoryConstant.OFFER_REPOSITORY);
			status = repository.updateOfferAmount(offerId, offerAmount);
			fillTransactionStatus(status);
		}catch(RuntimeException e) {
			logger.error("Error in com.demo.mongodb.springdata.service.OfferService.updateOfferAmount",e);
			fillTransactionStatus(status, e);
		}catch(Throwable e) {
			logger.error("Error in com.demo.mongodb.springdata.service.OfferService.updateOfferAmount",e);
			fillTransactionStatus(status, e);
		}finally {
			logger.info("Exiting "+ "com.demo.mongodb.springdata.service.OfferService.updateOfferAmount");
		}
		return status;
	}
}
