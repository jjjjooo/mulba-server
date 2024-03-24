package com.app.mulba.question.domain;


import com.app.mulba.common.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "qeustion")
@Entity
public class Question extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "writer_id", nullable = false, length = 20)
    private Long writerId;
    private String title;
    private String content;
    private Boolean isDeleted;

    @Builder // 테스트 빌더
    private Question(Long id, Long writerId, String title, String content, Boolean isDeleted) {
        this.id = id;
        this.writerId = writerId;
        this.title = title;
        this.content = content;
        this.isDeleted = isDeleted;
    }

    public static Question create(Long writerId, String title, String content) {
        return new Question(null, writerId, title, content, false);
    }
}
