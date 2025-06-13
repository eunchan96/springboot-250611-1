package com.back.domain.post.post.entity;

import com.back.domain.member.member.entity.Member;
import com.back.global.jpa.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Post extends BaseEntity {
    @ManyToOne // 다대일 관계, Post는 하나의 Member에 속한다.
    private Member author; // Member 타입으로 했지만, jpa는 알아서 authorId로 변경해준다.
    private String title;
    @Column(columnDefinition = "TEXT")
    private String content;

    public Post(Member author, String title, String content) {
        this.author = author;
        this.title = title;
        this.content = content;
    }
}
