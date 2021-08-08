package com.bloo.demoredis.controller;

import com.bloo.demoredis.dto.PostResponse;
import com.bloo.demoredis.service.ApiPostService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Created by Bloo
 * @Date: 2021/08/08
 */

@Slf4j
@RequiredArgsConstructor
@RestController
public class ApiPostController {

    private final ApiPostService apiPostService;

    @GetMapping("/api/posts")
    public ResponseEntity<List<PostResponse>> findAllPosts() {
        return ResponseEntity.ok(apiPostService.findAllPosts());
    }
}
