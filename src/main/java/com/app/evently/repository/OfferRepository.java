/**
 * 
 */
package com.app.evently.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.app.evently.infra.EventlyMongoConfig;
import com.app.evently.infra.Repository;
import com.app.evently.infra.TransactionStatus;
import com.app.evently.model.Offer;

/**
 * @author chasisin
 *
 */
@Component
public class OfferRepository extends Repository{
	static AbstractOfferRepository repository;
	
	private final String OFFER_NAME = "offerName";
	private final String OFFER_ID = "offerId";
	private final String OFFER_AMOUNT = "offerAmount";
	private final String PURCHAGE_AMOUNT = "purchageAmount";

	
	public OfferRepository(AbstractOfferRepository _repository){
		repository = _repository;
	}
	
	public void createOffer(Offer offer) {
		repository.insert(offer);
	}

	public List<Offer> getAllOffers(){
		List<Offer> offers = repository.findAll();
		return offers;
	}
	
	public void updateOffer(Offer offfer) {
		repository.save(offfer);
	}
	
	public void deleteAll() {
		repository.deleteAll();
	}
	
	public void insertAll(List<Offer> offers) {
		repository.insert(offers);
	}
	
	public Offer getOfferById(String offerId) {
		Offer offer = null;
		Optional<Offer> optionalOffer =  repository.findById(offerId);
		if(optionalOffer != null)
			offer = optionalOffer.get();
		return offer;
	}
	
	public Offer getOfferByName(String offerName) {
		Query query = new Query();
		query.addCriteria(Criteria.where(OFFER_NAME).is(offerName));
		Offer offfers = EventlyMongoConfig.getInstance().getMongoOperation().findOne(query, Offer.class);
		if(offfers != null)
			return offfers;
		return null;
	}
	
	public Offer getOfferAmounts(String offerId) {
		Query query = new Query();
		query.addCriteria(Criteria.where(OFFER_ID).is(offerId));
		query.fields().include(PURCHAGE_AMOUNT).include(OFFER_AMOUNT);
		Offer offer = EventlyMongoConfig.getInstance().getMongoOperation().findOne(query, Offer.class);
		return offer;
	}
	
	public TransactionStatus updateOfferAmount(String offerId, Double offerAmount) {
		TransactionStatus status = new TransactionStatus();
		try {
			Query query = new Query();
			query.addCriteria(Criteria.where(OFFER_ID).is(offerId));
			Update update = new Update();
			update.set(OFFER_AMOUNT, offerAmount);
			//UpdateResult result = EventlyMongoConfig.getInstance().getMongoOperation().updateFirst(query, update, Offer.class);
			EventlyMongoConfig.getInstance().getMongoOperation().updateMulti(query, update, Offer.class);
		}catch(Throwable e) {
			status.setErrorCode("updateOfferAmount");
			status.setMessage(e.getMessage());
		}
		return status;
	}
}
