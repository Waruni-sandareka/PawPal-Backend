package lk.pawpal.backend.controller;

import lk.pawpal.backend.model.Pet;
import lk.pawpal.backend.response.AddPetResponse;
import lk.pawpal.backend.response.GetPetResponse;
import lk.pawpal.backend.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://127.0.0.1:5173/")
public class PetController {

    @Autowired
    PetService petService;

    @PostMapping("/add-pet")
    public AddPetResponse addPet(@RequestBody Pet pet){
        return petService.addPet(pet);
    }

    //get pets
    @GetMapping("/getAllPets/{userId}")
    public GetPetResponse getAllPetsByUserId(@PathVariable Integer userId){
        return petService.getAllPetsByUserId(userId);
    }

}
