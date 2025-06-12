package com.back.domain.post.post.service;

import com.back.domain.post.post.Repository.PostRepository;
import com.back.domain.post.post.entity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public long count() {
        return postRepository.count();
    }

    public Post write(String title, String content) {
        Post post = new Post(title, content);
        postRepository.save(post);
        return post;
    }

    public Optional<Post> findById(int id) {
        return postRepository.findById(id);
    }

    public void modify(Post post, String title, String content) {
        /*
        boolean changed = false;

        if (!post.getTitle().equals(title)) {
            post.setTitle(title);
            changed = true;
        }

        if (!post.getContent().equals(content)) {
            post.setContent(content);
            changed = true;
        }

        if (changed) post.setModifyDate(LocalDateTime.now());

        postRepository.save(post);
        */

        post.setTitle(title);
        post.setContent(content);

        postRepository.save(post);
    }
}
