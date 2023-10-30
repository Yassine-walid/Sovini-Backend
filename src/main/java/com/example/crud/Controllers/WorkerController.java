package com.example.crud.Controllers;

import com.example.crud.Entity.Profession;
import com.example.crud.Entity.Worker;
import com.example.crud.Service.WorkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

@RequestMapping("api/worker")
public class WorkerController {

    @Autowired
    private WorkerServices workerServices;


    @GetMapping("/all")
    public List<Worker> getAllWorkers(){
        return workerServices.getWorkers();
    }

    @GetMapping("/allValidated")
    public List<Worker> getAllValidatedWorkers(){
        return workerServices.getValidatedWorkers();
    }

    @GetMapping("/allNotValidated")
    public List<Worker> getAllNotValidatedWorkers(){
        return workerServices.getNotValidatedWorkers();
    }



    @GetMapping("/all/{id}")
    public List<Worker> getAllWorkersByProffesion(@PathVariable String id){
        return workerServices.getWorkersByProfession(id);
    }

    @GetMapping("/allSponsored/{id}")
    public List<Worker> getAllWorkersSponsored(@PathVariable String id){
        return workerServices.getWorkersByProfessionAndSponsorisation(id);
    }

    @PostMapping("/add")
    public Worker saveWorker(@RequestBody Worker worker){

        try {
            workerServices.saveWorker(worker);
        }catch (Exception e){
            e.getStackTrace();
        }

        return worker;

    }

    @PutMapping("/sponsorisation/{id}")
    public String updateWorkerSponsorisation(@PathVariable("id") Long id) throws Exception {
        workerServices.paySponsorisation(id);
        return "worker";
    }
}
