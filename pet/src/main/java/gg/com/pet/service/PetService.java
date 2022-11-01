package gg.com.pet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import gg.com.pet.model.Pet;
import gg.com.pet.repository.IPet;

@Service
public class PetService {
	
	private IPet repository;
	
	 public PetService(IPet repository){
        this.repository = repository;
    }

	 public List<Pet> listPets(){
        List<Pet> lista = repository.findAll();
        return lista;
    }
	
	  public Optional<Pet> getById(Integer id){
	        Optional<Pet> question = repository.findById(id);
	        return (question);
	    }
	 
    public Pet addPet(Pet pet){
        Pet newPet = repository.save(pet);
        return (newPet);
    }

    public Pet updatePet(Pet pet){
        Pet newPet = repository.save(pet);
        return (newPet);
    }

    public boolean deletePet(Integer id){
        repository.deleteById(id);
        return true;
    }

}
