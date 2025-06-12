package com.back.domain.post.post.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
public class Post {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private final int id;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String content;

    public Post() {
        this("", "");
    }

    public Post(String title, String content) {
        this.id = 0;
        this.title = title;
        this.content = content;
    }
}
