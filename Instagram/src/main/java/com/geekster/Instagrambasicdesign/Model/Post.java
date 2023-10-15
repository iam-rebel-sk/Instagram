package com.geekster.Instagrambasicdesign.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;
    private LocalDateTime creationTime;
    private LocalDateTime updationTime;
    @NotBlank
    private String postData;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public Post(String postData,User user){
        this.postData=postData;
        this.user=user;
        creationTime = LocalDateTime.now();
        updationTime = LocalDateTime.now();
    }

}
