package lk.pawpal.backend.service;

import lk.pawpal.backend.model.Pet;
import lk.pawpal.backend.model.User;
import lk.pawpal.backend.repository.AppointmentRepository;
import lk.pawpal.backend.repository.PetRepository;
import lk.pawpal.backend.response.AddPetResponse;
import lk.pawpal.backend.response.GetPetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PetService {

    @Autowired
    PetRepository petRepository;
    public AddPetResponse addPet(Pet pet) {
        AddPetResponse response = new AddPetResponse();
        System.out.println(pet.getUser());

        Pet p = new Pet(pet.getName(), pet.getType(),pet.getBreed(),pet.getSex(),pet.getWeight(),pet.getSize(),pet.getAge(),pet.getEnergyLevel(),pet.getMedicationType(),pet.getIsHouseTrained(),pet.getIsFriendlyWithChildren(), pet.getUser());

        try {
            Pet savedPet = petRepository.save(p);

            response.setCode(1);
            response.setMessage("Successfully Added");
            response.setPet(savedPet);
            return response;
        } catch (Exception e) {
            System.out.println(e.toString());
            response.setCode(-1);
            response.setMessage("Something went wrong");
            response.setPet(null);
            return response;
        }
    }

    public GetPetResponse getAllPetsByUserId(Integer userId) {

        GetPetResponse response = new GetPetResponse();

        try {
            List<Pet> pets = petRepository.getAllPetsByUserId(userId);

            if(pets.size() > 0) {
                response.setMessage("Pets Details get Successfully !");
            } else {
                response.setMessage("Not added any pets yet !");
            }
            response.setCode(1);
            response.setPets(pets);
        } catch (Exception e) {
            response.setMessage("Error occurred!");
            response.setCode(-1);
        }
        return response;

    }

    @Autowired
    AppointmentRepository appointmentRepository;
    @Transactional
    public void deletePetsByUser(User user) {
        List<Pet> pets = petRepository.findByUser(user);
        // Delete appointments associated with each pet
        for (Pet pet : pets) {
            appointmentRepository.deleteByPet(pet);
        }
        petRepository.deleteAll(pets);
    }

    public Iterable<Pet> getAllPetList() {
        return petRepository.findAll();
    }
}
