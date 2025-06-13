package com.back.domain.post.post.repository;

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
        Post post = new Post("제목 new", "내용 new");
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

        assertThat(count).isEqualTo(4); // 테스트 데이터가 4개가 있어야 함
    }
}
