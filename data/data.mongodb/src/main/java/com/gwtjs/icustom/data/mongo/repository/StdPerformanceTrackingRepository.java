package com.gwtjs.icustom.data.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gwtjs.icustom.data.mongo.StdPerformance;

/**
 * 课程、章节学习记录维护Dao
 * 
 * @author aguang
 *
 */
public interface StdPerformanceTrackingRepository extends
		MongoRepository<StdPerformance, String> {
	public StdPerformance findByUserIdAndResId(Long userId, String resId);
}
