package com.gwtjs.icustom.data.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gwtjs.icustom.data.mongo.entity.StdItemAttemp;

/**
 * 学员单次学习记录维护Dao
 * 
 * @author aGuang
 *
 */
public interface StdAttempTrackingRepository extends
		MongoRepository<StdItemAttemp, String> {

}
