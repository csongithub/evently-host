/**
 * 
 */
package com.app.evently.seeder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.evently.infra.RepositoryConstant;
import com.app.evently.infra.RepositoryFactory;
import com.app.evently.model.Offer;
import com.app.evently.repository.OfferRepository;

/**
 * @author chasisin
 *
 */
@Component
public class OfferSeeder implements CommandLineRunner{

	private OfferRepository offerRepository;
	
	public OfferSeeder(){
		this.offerRepository = (OfferRepository)RepositoryFactory.getRepository(RepositoryConstant.OFFER_REPOSITORY);
	}
	
	@Override
	public void run(String... args) throws Exception {
		List<Offer> offerList = new ArrayList<Offer>(
										Arrays.asList(
											new Offer("OFR001", "Diwali Offer", 5000D, 10D),
											new Offer("OFR002", "Spring Sale", 8000D, 30D),
											new Offer("OFR003", "Winter Sale", 7000D, 10D),
											new Offer("OFR004", "New Year Dhamaka", 20000D, 50D)
										)
									);
	
		
		//drop all existing offers
		this.offerRepository.deleteAll();
		
		//add offers
		this.offerRepository.insertAll(offerList);
	}

}
