package com.bloo.demoredis.repository;

import com.bloo.demoredis.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Created by Bloo
 * @Date: 2021/08/08
 */


public interface PostRepository extends JpaRepository<Post, Long> {

}
