package wave.wwa.domain.common;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import wave.wwa.domain.problem.domain.Problem;
import wave.wwa.domain.problem.dto.request.ProblemRequestDto;
import wave.wwa.domain.problem.dto.response.ProblemResponseDto;
import wave.wwa.domain.review.domain.Review;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-26T22:44:46+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
@Component
public class ProblemMapperImpl implements ProblemMapper {

    @Override
    public Problem toEntity(ProblemRequestDto requestDto) {
        if ( requestDto == null ) {
            return null;
        }

        Problem.ProblemBuilder problem = Problem.builder();

        problem.title( requestDto.getTitle() );
        problem.link( requestDto.getLink() );
        problem.step( requestDto.getStep() );

        return problem.build();
    }

    @Override
    public ProblemResponseDto toDto(Problem problem) {
        if ( problem == null ) {
            return null;
        }

        ProblemResponseDto.ProblemResponseDtoBuilder problemResponseDto = ProblemResponseDto.builder();

        problemResponseDto.id( problem.getId() );
        problemResponseDto.title( problem.getTitle() );
        problemResponseDto.link( problem.getLink() );
        problemResponseDto.step( problem.getStep() );
        List<Review> list = problem.getReviewList();
        if ( list != null ) {
            problemResponseDto.reviewList( new ArrayList<Review>( list ) );
        }

        return problemResponseDto.build();
    }
}
