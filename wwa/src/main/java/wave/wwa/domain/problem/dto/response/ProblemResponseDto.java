package wave.wwa.domain.problem.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import wave.wwa.domain.review.domain.Review;
import wave.wwa.domain.tag.domain.ProblemTag;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProblemResponseDto {

    private Long id;

    private String title;

    private String link;

    private int step;

    @JsonIgnoreProperties({"problem"})
    private List<Review> reviewList;

    @JsonIgnoreProperties({"problem"})
    private List<ProblemTag> problemTagList;
}