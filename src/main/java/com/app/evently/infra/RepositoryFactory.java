/**
 * 
 */
package com.app.evently.infra;

import org.springframework.stereotype.Component;

import com.app.evently.repository.OfferRepository;

/**
 * @author chasisin
 *
 */
@Component
public class RepositoryFactory {
	
	private static OfferRepository _offerRepository;
	
	public RepositoryFactory(OfferRepository offerRepository) {
		_offerRepository = offerRepository;
		
	}
	
	public static Repository getRepository(String repository) {
		Repository _repository = null;
		if(RepositoryConstant.OFFER_REPOSITORY.equals(repository)) {
			_repository = _offerRepository;
		}
		return _repository;
	}
}
