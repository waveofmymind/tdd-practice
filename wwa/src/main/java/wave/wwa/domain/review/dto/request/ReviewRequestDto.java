package wave.wwa.domain.review.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Data
@Builder
public class ReviewRequestDto {

    @NotBlank
    private String content;

}