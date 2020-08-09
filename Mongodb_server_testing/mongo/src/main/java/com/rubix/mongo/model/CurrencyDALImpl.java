package com.rubix.mongo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;



import java.util.List;


public class CurrencyDALImpl implements CurrencyDAL {

	
	@Autowired
	private MongoTemplate mongoTemplate;

	
	@Override
	public List<Currency> getCurrencyByExpenseId(Long expenseId) {
		
		Query que = new Query();
		que.addCriteria(Criteria.where("expense."+ expenseId).exists(true));
		List<Currency> currency = mongoTemplate.find(que, Currency.class);
		return currency;
	}
	
	
	@Override
    public List<Pet> findAllByPetTypeAndPersonName(PetType petType, String personName, Pageable pageable) {
        LookupOperation lookup = LookupOperation.newLookup()
                 .from("Currency ")
                 .localField("_id")
                 .foreignField("petId")
                 .as("join_people");
        Aggregation aggregation = Aggregation.newAggregation(
                 Aggregation.match(Criteria.where("petType").is(petType)),
                 lookup,
                 Aggregation.match(Criteria.where("join_people.name").is(personName)),
                 Aggregation.skip(pageable.getPageNumber() * pageable.getPageSize()),
                 Aggregation.limit(pageable.getPageSize()));
        return mongoTemplate.aggregate(aggregation, Pet.class, Pet.class).getMappedResults();
    }
	
	
	

}
