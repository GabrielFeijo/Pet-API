package gg.com.pet.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gg.com.pet.model.Pet;
import gg.com.pet.service.PetService;

@RestController
@CrossOrigin("*")
@RequestMapping("/pets")
public class PetController {
	
	 private PetService petService;

	    public PetController(PetService petService){
	        this.petService = petService;
	    }

	    @GetMapping
	    public ResponseEntity<List<Pet>> listPets(){
	        return ResponseEntity.status(200).body(petService.listPets());
	    }
	
	    
	    @GetMapping("/{id}")
	    public ResponseEntity<Optional<Pet>> getById(@PathVariable Integer id) {
	        return ResponseEntity.status(200).body(petService.getById(id));
	    }
	    
	    @PostMapping
	    public ResponseEntity<Pet> addPet(@Valid @RequestBody Pet pet){
	        return ResponseEntity.status(201).body(petService.addPet(pet));
	    }

	    @PutMapping
	    public ResponseEntity<Pet> updatePet(@Valid @RequestBody Pet pet){
	        return ResponseEntity.status(200).body(petService.updatePet(pet));
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<?> deletePet(@PathVariable Integer id){
	        petService.deletePet(id);
	        return ResponseEntity.status(204).build();
	    }

}
