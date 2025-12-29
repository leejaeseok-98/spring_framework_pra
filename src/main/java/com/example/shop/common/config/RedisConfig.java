package com.example.shop.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@Configuration
@EnableRedisHttpSession(redisNamespace = "shboard:session") // 3-2 namespace 설정
public class RedisConfig {

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        // 3-3 host, port, password 설정
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName("localhost");
        redisStandaloneConfiguration.setPort(6379);
        // redisStandaloneConfiguration.setPassword("1234"); // 비밀번호가 있다면 주석 해제

        return new LettuceConnectionFactory(redisStandaloneConfiguration);
    }

    @Bean
    public RedisSerializer<Object> springSessionDefaultRedisSerializer() {
        // 객체를 JSON 형태로 변환해주는 Serializer
        return new GenericJackson2JsonRedisSerializer();
    }

}
