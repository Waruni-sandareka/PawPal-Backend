package lk.pawpal.backend.service;

import lk.pawpal.backend.model.User;
import lk.pawpal.backend.repository.UserRepository;
import lk.pawpal.backend.response.DeleteUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    public Iterable<User> getAllUserList() {
        return userRepository.findAll();

    }

    @Autowired
    PetService petService;

    @Transactional
    public DeleteUserResponse deleteUserById(Integer userId) {
        DeleteUserResponse response = new DeleteUserResponse();

        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isPresent()) {
            User userToDelete = userOptional.get();

            // Delete associated pets first
            petService.deletePetsByUser(userToDelete);

            // Then delete the user
            userRepository.delete(userToDelete);

            response.setMessage("User and associated pets deleted successfully");
            response.setCode(200);
            response.setUser(userToDelete);
        } else {
            response.setMessage("User not found with ID: " + userId);
            response.setCode(404);
            response.setUser(null);
        }

        return response;
    }
}
