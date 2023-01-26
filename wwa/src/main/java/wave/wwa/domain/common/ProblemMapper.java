package wave.wwa.domain.common;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import wave.wwa.domain.problem.domain.Problem;
import wave.wwa.domain.problem.dto.request.ProblemRequestDto;
import wave.wwa.domain.problem.dto.response.ProblemResponseDto;

@Mapper(componentModel = "spring")
public interface ProblemMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "problemTagList", ignore = true)
    @Mapping(target = "reviewList", ignore = true)
    Problem toEntity(ProblemRequestDto requestDto);

    ProblemResponseDto toDto(Problem problem);


}