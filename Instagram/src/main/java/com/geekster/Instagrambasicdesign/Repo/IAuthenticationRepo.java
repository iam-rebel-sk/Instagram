package com.geekster.Instagrambasicdesign.Repo;

import com.geekster.Instagrambasicdesign.Model.AuthenticationToken;
import com.geekster.Instagrambasicdesign.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthenticationRepo extends JpaRepository<AuthenticationToken,Long> {

    AuthenticationToken findByUser(User user);

    AuthenticationToken findByValue(String tokenValue);
}
