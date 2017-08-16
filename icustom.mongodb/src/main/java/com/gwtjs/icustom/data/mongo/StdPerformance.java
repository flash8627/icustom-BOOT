package com.gwtjs.icustom.data.mongo;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import com.gwtjs.icustom.data.mongo.entity.StdItemPerformance;

/**
 * 学员课件学习记录实体类
 * 
 * @author aGuang
 *
 */
public class StdPerformance extends StdProperties {
	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 *
	 */
	@Id
	private ObjectId id;
	/**
	 * 课件所有章节学习记录列表
	 */
	private List<StdItemPerformance> itemPerformances = new ArrayList<StdItemPerformance>();

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public List<StdItemPerformance> getItemPerformances() {
		return itemPerformances;
	}

	public void setItemPerformances(List<StdItemPerformance> itemPerformances) {
		this.itemPerformances = itemPerformances;
	}

}
