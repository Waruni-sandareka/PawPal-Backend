package lk.pawpal.backend.controller;

import lk.pawpal.backend.request.LoginRequest;
import lk.pawpal.backend.model.User;
import lk.pawpal.backend.response.AuthResponse;
import lk.pawpal.backend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://127.0.0.1:5173/")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/sign-up")
    public AuthResponse signup(@RequestBody User user){
        return authService.signup(user);
    }

    @PostMapping("/sign-in")
    public AuthResponse signIn(@RequestBody LoginRequest loginRequest){
        return authService.signIn(loginRequest);
    }

}
