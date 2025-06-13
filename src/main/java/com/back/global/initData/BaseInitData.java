package com.back.global.initData;

import com.back.domain.member.member.entity.Member;
import com.back.domain.member.member.service.MemberService;
import com.back.domain.post.post.entity.Post;
import com.back.domain.post.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Configuration
@RequiredArgsConstructor
public class BaseInitData {
    @Autowired
    @Lazy
    private BaseInitData self;

    private final PostService postService;
    private final MemberService memberService;

    @Bean
    ApplicationRunner baseInitDataApplicationRunner() {
        return args -> {
            self.work1();
            // self.work2();
            // self.work3();
        };
    }

    @Transactional
    void work1() {
        if(memberService.count() > 0) return; // SELECT COUNT(*) FROM member;
        Member memberSystem = memberService.join("system", "1234", "시스템");
        Member memberAdmin = memberService.join("admin", "1234", "관리자");
        Member memberUser1 = memberService.join("user1", "1234", "유저1");
        Member memberUser2 = memberService.join("user2", "1234", "유저2");
        Member memberUser3 = memberService.join("user3", "1234", "유저3");

        if(postService.count() > 0) return; // SELECT COUNT(*) FROM post;

        Post post1 = postService.write(memberUser1, "제목 1", "내용 1"); // INSERT INTO post SET title = '제목 1';
        Post post2 = postService.write(memberUser2, "제목 2", "내용 2");

        System.out.println("기본 데이터가 초기화되었습니다.");
    }

    @Transactional(readOnly = true)
    void work2() {
        Optional<Post> opPost1 = postService.findById(1); // SELECT * FROM post WHERE id = 1;

        Post post1 = opPost1.get();

        System.out.println("Post 1: " + post1);
    }

    @Transactional
    void work3() {
        Optional<Post> opPost1 = postService.findById(1);
        Post post1 = opPost1.get();

        postService.modify(post1, "제목1 수정", "내용1 수정");
        // UPDATE post SET title = '제목1 수정', content = '내용1 수정', modifiedDate = NOW() WHERE id = 1;
        System.out.println("Post 1: " + post1);
    }
}
