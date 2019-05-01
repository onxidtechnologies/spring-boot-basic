package com.onxidtechnologies.springbootbasic.repository;

import com.onxidtechnologies.springbootbasic.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
public interface UserRepository extends MongoRepository<User, String> {
}
