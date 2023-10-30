package com.example.crud.Repository;

import com.example.crud.Entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WorkerRepository extends JpaRepository<Worker,Long> {
    List<Worker> getWorkersByProfessionAndValidatedIsTrue(String profession);

    @Query(value = "SELECT * FROM worker where sponsored=true and validated=true order by RAND() LIMIT 5", nativeQuery = true)

    List<Worker> getSponsoreValid(String profession);


    List<Worker> getByValidatedIsTrue();

    List<Worker> getByValidatedIsFalse();
}
