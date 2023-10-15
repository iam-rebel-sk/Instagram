package com.geekster.Instagrambasicdesign.Service;

import com.geekster.Instagrambasicdesign.Model.AuthenticationToken;
import com.geekster.Instagrambasicdesign.Model.User;
import com.geekster.Instagrambasicdesign.Model.dto.AuthInpDto;
import com.geekster.Instagrambasicdesign.Repo.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class UserService {
    @Autowired
    IUserRepo iUserRepo;

    @Autowired
    AuthenticationService authenticationService;

    public void registerUser(User user) {

        try {
            user.setPassword(PasswordEncryptor.encrypt(user.getPassword()));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        user.setUserId(null);
        iUserRepo.save(user);

    }

    public AuthInpDto signIn(String email, String password) {
        User user;
        try {
            user = getUserForValidEmailPassword(email,password);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        if(user==null)return null;
        AuthenticationToken userAuthToken=authenticationService.getAuthToken(user);
        return  new AuthInpDto(email,userAuthToken.getToken());
    }

    private User getUserForValidEmailPassword(String email, String password) throws NoSuchAlgorithmException {
        User user=iUserRepo.findFirstByEmail(email);
        if(user==null)return null;
        return user.getPassword().equals(PasswordEncryptor.encrypt(password))?user:null;
    }

    public String signOut(AuthInpDto authInpDto) {
        AuthenticationToken userAuthToken=authenticationService.getTokenIfValid(authInpDto);
        if(userAuthToken!=null){
            authenticationService.deleteAuthToken(userAuthToken);
            return "logged out sucessfully";
        }
        return "wrong acess";
    }
}
