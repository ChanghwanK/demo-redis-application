package com.bloo.demoredis.service;

import com.bloo.demoredis.dto.PostResponse;
import com.bloo.demoredis.repository.PostRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @Created by Bloo
 * @Date: 2021/08/08
 */

@Slf4j
@RequiredArgsConstructor
@Service
public class ApiPostService {

    private final PostRepository postRepository;

    @Cacheable(value = "getPosts")
    public List<PostResponse> findAllPosts () {
        var posts = postRepository.findAll();

        return posts
            .stream()
            .map(PostResponse::of)
            .collect(Collectors.toList());
    }
}
