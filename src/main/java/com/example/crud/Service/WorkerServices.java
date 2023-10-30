package com.example.crud.Service;

import com.example.crud.Entity.Profession;
import com.example.crud.Entity.Worker;
import com.example.crud.Repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerServices {

    @Autowired
    private WorkerRepository workerRepository;

    public List<Worker> getWorkers() {

        return workerRepository.findAll();
    }

    public List<Worker> getWorkersByProfession(String id){
        return workerRepository.getWorkersByProfessionAndValidatedIsTrue(id);
    };

    public List<Worker> getValidatedWorkers(){
        return workerRepository.getByValidatedIsTrue();
    };

    public List<Worker> getNotValidatedWorkers(){
        return workerRepository.getByValidatedIsFalse();
    };

    public List<Worker> getWorkersByProfessionAndSponsorisation(String id){
        return workerRepository.getSponsoreValid(id);
    };

    public void saveWorker(Worker worker){
        if(worker.getImageUrl() == null){
            worker.setImageUrl("https://placehold.co/400x400");
        }
        worker.setValidated(false);
        worker.setSponsored(false);
        worker.setScore(0);
        workerRepository.save(worker);
    }


    public void paySponsorisation(Long id) throws Exception {
        Optional<Worker> workerData = workerRepository.findById(id);

        if (workerData.isPresent()) {
            Worker workerDataUpdated = workerData.get();
            if(workerDataUpdated.getSponsored()){
                workerDataUpdated.setSponsored(false);
            }else {
                workerDataUpdated.setSponsored(true);
            }

            workerRepository.save(workerDataUpdated);
        } else {
            throw new Exception("Worker not found");
        }
    }


}
