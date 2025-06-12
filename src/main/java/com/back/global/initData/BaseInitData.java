package com.back.global.initData;

import com.back.domain.post.post.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaseInitData {
    @Autowired
    private PostRepository postRepository;

    @Bean
    ApplicationRunner baseInitDataApplicationRunner() {
        return args -> {
            System.out.println("기본 데이터가 초기화되었습니다.");

            postRepository.count(); // SELECT COUNT(*) FROM post;
        };
    }
}
