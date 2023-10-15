package com.geekster.Instagrambasicdesign.Controller;

import com.geekster.Instagrambasicdesign.Model.Post;
import com.geekster.Instagrambasicdesign.Model.dto.AuthInpDto;
import com.geekster.Instagrambasicdesign.Model.dto.PostDto;
import com.geekster.Instagrambasicdesign.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {
    @Autowired
    PostService postService;

    @PostMapping("user/post")
    public String createPost(@RequestBody PostDto postDto){
        return postService.createPost(postDto);
    }

    @PutMapping("/user/post/id/{postId}")
    public String updateThePost(@PathVariable Integer postId, @RequestBody AuthInpDto authInpDto, @RequestParam String data){
        return postService.updateThePost(postId,authInpDto,data);
    }
}
