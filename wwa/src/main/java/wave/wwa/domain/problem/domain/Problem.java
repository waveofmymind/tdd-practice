package wave.wwa.domain.problem.domain;

import jakarta.persistence.*;
import lombok.*;
import wave.wwa.domain.BaseEntity;
import wave.wwa.domain.review.domain.Review;
import wave.wwa.domain.tag.domain.ProblemTag;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.singletonList;

@Entity
@Table(name = "problem")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder
@AllArgsConstructor
public class Problem extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="problem_id")
    private Long id;

    @Column(name="title")
    private String title;
    @Column(name="link")
    private String link;

    @Builder.Default
    @Column(name="step")
    private int step=1;

    @Builder.Default
    @OneToMany(mappedBy = "problem", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ProblemTag> problemTagList = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "problem", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    public void setProblemTagList(List<ProblemTag> problemTagList) {
        this.problemTagList = problemTagList;
    }

    public void setReview(Review review) {
        this.reviewList = singletonList(review);
    }

}