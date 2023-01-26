package wave.wwa.domain.common;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import wave.wwa.domain.problem.domain.Problem;
import wave.wwa.domain.problem.dto.request.ProblemRequestDto;
import wave.wwa.domain.review.domain.Review;
import wave.wwa.domain.review.dto.request.ReviewRequestDto;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    @Mapping(target="problem", source = "problem")
    @Mapping(target = "id",ignore = true)
    Review toEntity(ProblemRequestDto requestDto, Problem problem);

    @Mapping(target = "problem", source = "problem")
    @Mapping(target = "id", ignore = true)
    Review toEntity(Problem problem, ReviewRequestDto requestDto);

    @Mapping(target = "problem", ignore = true)
    @Mapping(target = "id", source = "id")
    Review toEntity(Long id, ReviewRequestDto requestDto);
}