package com.geekster.Instagrambasicdesign.Service;

import com.geekster.Instagrambasicdesign.Model.AuthenticationToken;
import com.geekster.Instagrambasicdesign.Model.Post;
import com.geekster.Instagrambasicdesign.Model.User;
import com.geekster.Instagrambasicdesign.Model.dto.AuthInpDto;
import com.geekster.Instagrambasicdesign.Model.dto.PostDto;
import com.geekster.Instagrambasicdesign.Repo.IPostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PostService {

    @Autowired
    IPostRepo iPostRepo;

    @Autowired
    AuthenticationService authenticationService;

    public String createPost(PostDto postDto) {
        AuthenticationToken userAuthToken=authenticationService.getTokenIfValid(postDto.getAuthInpDto());
        if(userAuthToken!=null){
            Post post=new Post(postDto.getData(),userAuthToken.getUser());
            iPostRepo.save(post);
            return "posted sucessfully";
        }
        return "wrong credentials";
    }

    public String updateThePost(Integer postId, AuthInpDto authInpDto, String data) {
        AuthenticationToken userAuthToken=authenticationService.getTokenIfValid(authInpDto);
        if(userAuthToken==null)return "don't have authority to update";
        Post post=iPostRepo.findById(postId).orElseThrow();
        if(userAuthToken.getUser().equals(post.getUser())){
            post.setPostData(data);
            post.setUpdationTime(LocalDateTime.now());
            iPostRepo.save(post);
            return "updated sucessfully";
        }
        return "not have authority";
    }
}
