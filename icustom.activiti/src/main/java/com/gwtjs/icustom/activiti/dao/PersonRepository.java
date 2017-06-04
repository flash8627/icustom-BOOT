package com.gwtjs.icustom.activiti.dao;

import com.gwtjs.icustom.activiti.model.Person;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by aGuang 2017/05/08.
 */
public interface PersonRepository extends JpaRepository<Person, Long> {
	
	public Person findByPersonName(String personName);
	
}

