package wave.wwa.domain.review.domain;

import jakarta.persistence.*;
import lombok.*;

import wave.wwa.domain.BaseEntity;
import wave.wwa.domain.problem.domain.Problem;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Entity
@Builder
@Table(name="review")
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id", updatable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "problem_id", updatable = false)
    private Problem problem;

    @Lob
    private String content;
}