package com.testtriangle.forexengine.data.repository;

import com.testtriangle.forexengine.domain.Forex;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ForexRepository extends MongoRepository<Forex, String> {
}
