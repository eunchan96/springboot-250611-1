package com.back.domain.post.post.service;

import com.back.domain.post.post.Repository.PostRepository;
import com.back.domain.post.post.entity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public long count() {
        return postRepository.count();
    }

    public Post save(Post post) {
        return postRepository.save(post);
    }

    public Optional<Post> findById(int id) {
        return postRepository.findById(id);
    }

    public void modify(Post post, String title, String content) {
        post.setTitle(title);
        post.setContent(content);
        post.setModifiedDate(LocalDateTime.now());

        postRepository.save(post);
    }
}
