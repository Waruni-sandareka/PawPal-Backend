package lk.pawpal.backend.controller;

import lk.pawpal.backend.model.LoginCredentials;
import lk.pawpal.backend.model.Owner;
import lk.pawpal.backend.response.OwnerResponse;
import lk.pawpal.backend.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://127.0.0.1:5173/")
public class PawPalController {

    @Autowired
    LoginService loginService;

    @PostMapping("/register")
    public OwnerResponse register(@RequestBody Owner owner){
        return loginService.register(owner);
    }

    @PostMapping("/login")
    public OwnerResponse login(@RequestBody LoginCredentials loginCredentials) {
        return loginService.login(loginCredentials);
    }



}
