package com.geekster.Instagrambasicdesign.Repo;

import com.geekster.Instagrambasicdesign.Model.Post;
import com.geekster.Instagrambasicdesign.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPostRepo extends JpaRepository<Post,Integer> {
}
