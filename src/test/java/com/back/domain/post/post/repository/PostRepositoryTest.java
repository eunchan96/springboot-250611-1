package com.back.domain.post.post.repository;

import com.back.domain.member.member.Repository.MemberRepository;
import com.back.domain.member.member.entity.Member;
import com.back.domain.post.post.Repository.PostRepository;
import com.back.domain.post.post.entity.Post;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ActiveProfiles("test")
@SpringBootTest
@Transactional
public class PostRepositoryTest {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private MemberRepository memberRepository;

    @Test
    @DisplayName("2번 글 조회")
    void t1() {
        Post post1 = postRepository.findById(2).get();

        assertThat(post1.getTitle()).isEqualTo("제목 2");
        assertThat(post1.getContent()).isEqualTo("내용 2");
    }

    @Test
    @DisplayName("글 작성")
    void t2() {
        Member memberUser1 = memberRepository.findById(3).get();
        Post post = new Post(memberUser1, "제목 new", "내용 new");
        assertThat(post.getId()).isEqualTo(0); // ID는 아직 생성되지 않음
        postRepository.save(post);

        assertThat(post.getId()).isGreaterThan(0); // ID가 자동 생성되므로 0보다 커야 함
        assertThat(post.getTitle()).isEqualTo("제목 new");
        assertThat(post.getContent()).isEqualTo("내용 new");
    }

    @Test
    @DisplayName("글 개수 조회")
    void t3() {
        long count = postRepository.count();

        assertThat(count).isEqualTo(2);
    }
}
