package com.geekster.Instagrambasicdesign.Service;

import com.geekster.Instagrambasicdesign.Model.AuthenticationToken;
import com.geekster.Instagrambasicdesign.Model.User;
import com.geekster.Instagrambasicdesign.Model.dto.AuthInpDto;
import com.geekster.Instagrambasicdesign.Repo.IAuthenticationRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class AuthenticationService {

    @Autowired
    IAuthenticationRepo authenticationRepo;

    public AuthenticationToken getAuthToken(User user) {
        AuthenticationToken userAuthToken = authenticationRepo.findByUser(user);
        if(userAuthToken!=null)return userAuthToken;
        userAuthToken = new AuthenticationToken(user);
        authenticationRepo.save(userAuthToken);
        return userAuthToken;

    }

    public AuthenticationToken getTokenIfValid(AuthInpDto authInpDto) {
        AuthenticationToken userAuthToken = authenticationRepo.findByValue(authInpDto.getTokenValue());
        return userAuthToken.getUser().getEmail().equals(authInpDto.getEmail())?userAuthToken:null;
    }


    public void deleteAuthToken(AuthenticationToken userAuthToken) {
        authenticationRepo.delete(userAuthToken);
    }
}
