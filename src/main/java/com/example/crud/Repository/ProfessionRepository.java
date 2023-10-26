package com.example.crud.Repository;

import com.example.crud.Entity.Profession;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessionRepository extends MongoRepository<Profession,String> {
}
