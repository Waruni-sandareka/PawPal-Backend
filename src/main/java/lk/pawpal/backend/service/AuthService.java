package lk.pawpal.backend.service;

import lk.pawpal.backend.request.LoginRequest;
import lk.pawpal.backend.model.User;
import lk.pawpal.backend.repository.UserRepository;
import lk.pawpal.backend.response.AuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class AuthService {

    @Autowired
    UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public AuthResponse signup(User user) {
        AuthResponse response = new AuthResponse();

        // Encrypt the password before storing
        String encryptedPassword = passwordEncoder.encode(user.getPassword());

        User u = new User(user.getFirstName(), user.getLastName(), user.getEmail(), encryptedPassword);

        try {
            User savedUser = userRepository.save(u);

            response.setCode(1);
            response.setMessage("Successfully Registered");
            response.setUser(savedUser);
            return response;
        } catch (Exception e) {
            response.setCode(-1);
            response.setMessage("Something went wrong");
            response.setUser(null);
            return response;
        }
    }

    public AuthResponse signIn(LoginRequest loginRequest) {
        AuthResponse response = new AuthResponse();

        try {
            User user = userRepository.getDetails(loginRequest.getEmail());

            if (user == null) {
                response.setMessage("Email is incorrect");
                response.setCode(-1);
                return response;
            } else {
                // Use BCryptPasswordEncoder to check the encrypted password
                if (passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
                    response.setMessage("Login Successfully");
                    response.setCode(1);
                    response.setUser(user);
                    return response;
                } else {
                    response.setMessage("Password incorrect");
                    response.setCode(-1);
                    return response;
                }
            }
        } catch (Exception e) {
            response.setMessage("Error Occurred");
            response.setCode(-1);
            return response;
        }
    }
}
