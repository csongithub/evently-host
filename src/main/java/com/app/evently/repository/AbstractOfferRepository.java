/**
 * 
 */
package com.app.evently.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.app.evently.model.Offer;

/**
 * @author chasisin
 *
 */
@Repository
public interface AbstractOfferRepository extends MongoRepository<Offer, String> {

}
