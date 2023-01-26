package wave.wwa.domain.problem.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProblemRequestDto {

    @NotBlank
    private String title;

    @NotNull
    private String link;

    @Builder.Default
    private int step = 1;

    @NotNull
    private ArrayList<String> tagList;

    @NotBlank
    private String content;

}