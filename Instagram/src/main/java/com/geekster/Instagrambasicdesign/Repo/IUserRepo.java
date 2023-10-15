package com.geekster.Instagrambasicdesign.Repo;

import com.geekster.Instagrambasicdesign.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<User, Long> {
    User findFirstByEmail(String email);
}
