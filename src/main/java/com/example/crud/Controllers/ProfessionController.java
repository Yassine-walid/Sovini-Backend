package com.example.crud.Controllers;

import com.example.crud.Entity.Profession;
import com.example.crud.Repository.ProfessionRepository;
import com.example.crud.Service.ProfessionServices;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

@RequestMapping("api/profession")
public class ProfessionController {

    @Autowired
    private ProfessionServices professionServices;

    @GetMapping("/all")
    public List<Profession> getAllProfessions(){
        return professionServices.getAllProfessions();
    }

    @PostMapping("/add")
    public Profession saveProfession(@RequestBody Profession profession){

        try {
            professionServices.saveProfession(profession);
        }catch (Exception e){
            e.getStackTrace();
        }

        return profession;

    }

    @PutMapping("/edit/{id}")
    public Profession updateProfession(@PathVariable("id") String id,@RequestBody Profession profession) throws Exception {
        professionServices.updateProfession(id,profession);
        return profession;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProfession(@PathVariable("id") String id) throws Exception{
        professionServices.deleteProfession(id);
        return "Profession deleted";
    }
}
