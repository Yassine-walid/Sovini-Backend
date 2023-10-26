package com.example.crud.Service;

import com.example.crud.Entity.Profession;
import com.example.crud.Repository.ProfessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessionServices {

    @Autowired
    private ProfessionRepository professionRepository;

    public List<Profession> getAllProfessions(){
        return professionRepository.findAll();
    }

    public void saveProfession(Profession profession){
        if(profession.getIcon() == null){
            profession.setIcon("https://placehold.co/400x400");
        }
        profession.setJobsCount(0);
        professionRepository.save(profession);
    }

    public void updateProfession(String id, Profession profession) throws Exception {
      Optional<Profession> professionData = professionRepository.findById(id);

      if(professionData.isPresent()){
          Profession professionDataUpdated = professionData.get();
          professionDataUpdated.setId(id);
          if(profession.getName() != null) professionDataUpdated.setName(profession.getName());
          if(profession.getDescription() != null) professionDataUpdated.setDescription(profession.getDescription());
          if(profession.getIcon() != null) professionDataUpdated.setIcon(profession.getIcon());
          professionDataUpdated.setJobsCount(professionDataUpdated.getJobsCount());

          professionRepository.save(professionDataUpdated);
      }else {
          throw new Exception("Profession not found");
      }
    }

    public void deleteProfession(String id) throws Exception{
        Optional<Profession> profession = professionRepository.findById(id);
        if (profession.isPresent()){
            professionRepository.deleteById(id);
        }else {
            throw new Exception("Profession not found");
        }
    }

}
