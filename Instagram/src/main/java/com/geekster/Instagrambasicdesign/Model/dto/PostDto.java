package com.geekster.Instagrambasicdesign.Model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
    private String data;
    private AuthInpDto authInpDto;
}
