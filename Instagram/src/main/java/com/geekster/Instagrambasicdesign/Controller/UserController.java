package com.geekster.Instagrambasicdesign.Controller;

import com.geekster.Instagrambasicdesign.Model.User;
import com.geekster.Instagrambasicdesign.Model.dto.AuthInpDto;
import com.geekster.Instagrambasicdesign.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController
{
    @Autowired
    UserService userService;

    //signup
    @PostMapping("user/signup")
    public String registerUser(@RequestBody User newUser)
    {
        userService.registerUser(newUser);
        return "added sucessfully";
    }

    //sign in
    @PostMapping("/user/signin")
    public AuthInpDto signIn(String email, String password){
        return userService.signIn(email,password);
    }
    @DeleteMapping("user/signOut")
    public String signOut(AuthInpDto authInpDto){
        return userService.signOut(authInpDto);
    }
}
