package com.back.domain.post.post.service;

import com.back.domain.post.post.Repository.PostRepository;
import com.back.domain.post.post.entity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public long count() {
        return postRepository.count();
    }

    public Post write(int authorId, String title, String content) {
        Post post = new Post(authorId, title, content);
        postRepository.save(post);
        return post;
    }

    public Optional<Post> findById(int id) {
        return postRepository.findById(id);
    }

    public void modify(Post post, String title, String content) {
        post.setTitle(title);
        post.setContent(content);

        // postRepository.save(post);
        // save() 메서드를 호출하지 않아도, JPA가 엔티티의 상태를 감지하여 자동으로 업데이트한다.
    }
}
