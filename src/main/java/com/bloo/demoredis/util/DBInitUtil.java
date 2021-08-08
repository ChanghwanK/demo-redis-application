package com.bloo.demoredis.util;

import com.bloo.demoredis.entity.Post;
import com.bloo.demoredis.repository.PostRepository;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @Created by Bloo
 * @Date: 2021/08/08
 */
@RequiredArgsConstructor
@Component
public class DBInitUtil {

    private  final PostRepository postRepository;

    @PostConstruct
    public void dbInit() {
        List<Post> posts = new ArrayList<>();
        for (int i = 0; i <= 50; i++ ) {
            Post post = new Post("title_" + i, "content_" + i);
            posts.add(post);
        }
        postRepository.saveAll(posts);
    }
}
