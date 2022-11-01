package gg.com.pet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gg.com.pet.model.Pet;

public interface IPet extends JpaRepository<Pet, Integer> {
}
