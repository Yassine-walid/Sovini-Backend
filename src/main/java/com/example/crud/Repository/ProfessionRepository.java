package com.example.crud.Repository;

import com.example.crud.Entity.Profession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessionRepository extends JpaRepository<Profession,Long> {

    @Query("SELECT id, Name FROM Profession ")
    List<String> findProfessionName();

}
