package com.bloo.demoredis.dto;

import com.bloo.demoredis.entity.Post;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @Created by Bloo
 * @Date: 2021/08/08
 */

@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class PostResponse {

    private String title;
    private String content;


    public static PostResponse of ( Post post) {
        return PostResponse.builder()
            .title(post.getTitle())
            .content(post.getContent())
            .build();
    }

}
