package com.nikitha.fsd.recommend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.nikitha.fsd.recommend.model.GifConsumed;
import com.nikitha.fsd.recommend.model.GifModelToSave;


@Repository
public interface RecommendRepository extends MongoRepository<GifModelToSave, String> {
	

}
