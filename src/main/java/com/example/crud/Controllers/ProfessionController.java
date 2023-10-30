package com.example.crud.Controllers;

import com.example.crud.Entity.Profession;
import com.example.crud.Service.ProfessionServices;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/allNames")
        public List<String> getAllProfessionsNames(){
        return professionServices.getAllProfessionsNames();
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
    public Profession updateProfession(@PathVariable("id") Long id,@RequestBody Profession profession) throws Exception {
        professionServices.updateProfession(id,profession);
        return profession;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProfession(@PathVariable("id") Long id) throws Exception{
        professionServices.deleteProfession(id);
        return "Profession deleted";
    }


}
