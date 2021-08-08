package com.bloo.demoredis.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @Created by Bloo
 * @Date: 2021/08/08
 */

@EqualsAndHashCode(of="id")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Post implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;

    @Builder
    public Post ( String title, String content ) {
        this.title = title;
        this.content = content;
    }
}
