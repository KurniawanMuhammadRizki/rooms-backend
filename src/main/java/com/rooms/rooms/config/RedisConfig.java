package com.rooms.rooms.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
public class RedisConfig {

     @Bean
     public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory connectionFactory) {
          RedisTemplate<String, String> template = new RedisTemplate<>();
          template.setConnectionFactory(connectionFactory);
          return template;
     }

     @Bean
     public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory connectionFactory) {
          return new StringRedisTemplate(connectionFactory);
     }

     @Bean
     public ObjectMapper objectMapper() {
          return new ObjectMapper();
     }
}