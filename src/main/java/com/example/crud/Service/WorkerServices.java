package com.example.crud.Service;

import com.example.crud.Entity.Profession;
import com.example.crud.Entity.Worker;
import com.example.crud.Repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerServices {

    @Autowired
    private WorkerRepository workerRepository;

    public List<Worker> getWorkersByProfession(String id){
        return workerRepository.getWorkersByProfession(id);
    };

    public void saveWorker(Worker worker){
        if(worker.getImageUrl() == null){
            worker.setImageUrl("https://placehold.co/400x400");
        }
        worker.setScore(0);
        workerRepository.save(worker);
    }

}
