package com.example.crud.Repository;

import com.example.crud.Entity.Worker;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface WorkerRepository extends MongoRepository<Worker,String> {
    List<Worker> getWorkersByProfession(String profession);
}
