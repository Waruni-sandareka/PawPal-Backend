package lk.pawpal.backend.controller;

import lk.pawpal.backend.model.User;
import lk.pawpal.backend.response.DeleteUserResponse;
import lk.pawpal.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://127.0.0.1:5173/")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/getAllUserList")
    public Iterable<User> getAllUserList(){

        return userService.getAllUserList();
    }

    @DeleteMapping("/deleteUser/{userId}")
    public DeleteUserResponse deleteUserById(@PathVariable Integer userId){
        return userService.deleteUserById(userId);
    }


}
