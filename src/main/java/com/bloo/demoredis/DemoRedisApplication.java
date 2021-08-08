package com.bloo.demoredis;

import com.bloo.demoredis.entity.Post;
import com.bloo.demoredis.repository.PostRepository;
import com.bloo.demoredis.util.DBInitUtil;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@RequiredArgsConstructor
@SpringBootApplication
public class DemoRedisApplication {

    public static void main ( String[] args ) {
        SpringApplication.run(DemoRedisApplication.class, args);
    }
}
