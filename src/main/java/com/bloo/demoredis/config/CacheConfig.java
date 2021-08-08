package com.bloo.demoredis.config;

import com.bloo.demoredis.util.CacheKey;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.CacheKeyPrefix;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @Created by Bloo
 * @Date: 2021/08/08
 */

@RequiredArgsConstructor
@Configuration
public class CacheConfig {

    private final RedisConnectionFactory connectionFactory;

    @Bean
    public CacheManager redisCacheManager () {
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration
            .defaultCacheConfig()
            .disableCachingNullValues()
            .entryTtl(Duration.ofSeconds(CacheKey.DEFAULT_EXPIRE_SEC))
            .computePrefixWith(CacheKeyPrefix.simple())
            // Redis Cache 저장 방식은 StringSerializer로 지정
            .serializeKeysWith(RedisSerializationContext.SerializationPair
                .fromSerializer(new StringRedisSerializer()));

        Map<String, RedisCacheConfiguration> configurations = new HashMap<>();

        configurations.put(
            CacheKey.POST, RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofSeconds(CacheKey.POST_EXPIRE_SEC))
        );

        configurations.put(
            CacheKey.POSTS, RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofSeconds(CacheKey.POST_EXPIRE_SEC))
        );

//        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
//            .serializeKeysWith(RedisSerializationContext.SerializationPair
//                .fromSerializer(new StringRedisSerializer()))
//            .serializeValuesWith(RedisSerializationContext.SerializationPair
//                .fromSerializer(new GenericJackson2JsonRedisSerializer()));

        return RedisCacheManager.RedisCacheManagerBuilder
            .fromConnectionFactory(connectionFactory)
            .withInitialCacheConfigurations(configurations)
            .cacheDefaults(redisCacheConfiguration)
            .build();
    }


}
