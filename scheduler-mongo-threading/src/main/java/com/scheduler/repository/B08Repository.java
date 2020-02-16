package com.scheduler.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.scheduler.model.B08Message;

@Repository
public interface B08Repository extends MongoRepository<B08Message, String>{

}
