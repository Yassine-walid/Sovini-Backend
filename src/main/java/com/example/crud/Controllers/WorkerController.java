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

    @GetMapping("/all/{id}")
    public List<Worker> getAllWorkers(@PathVariable String id){
        return workerServices.getWorkersByProfession(id);
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
}
