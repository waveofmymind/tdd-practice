package wave.wwa.domain.common;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import wave.wwa.domain.problem.domain.Problem;
import wave.wwa.domain.problem.dto.request.ProblemRequestDto;
import wave.wwa.domain.review.domain.Review;
import wave.wwa.domain.review.dto.request.ReviewRequestDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-26T22:44:45+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
@Component
public class ReviewMapperImpl implements ReviewMapper {

    @Override
    public Review toEntity(ProblemRequestDto requestDto, Problem problem) {
        if ( requestDto == null && problem == null ) {
            return null;
        }

        Review.ReviewBuilder review = Review.builder();

        if ( requestDto != null ) {
            review.content( requestDto.getContent() );
        }
        review.problem( problem );

        return review.build();
    }

    @Override
    public Review toEntity(Problem problem, ReviewRequestDto requestDto) {
        if ( problem == null && requestDto == null ) {
            return null;
        }

        Review.ReviewBuilder review = Review.builder();

        if ( requestDto != null ) {
            review.content( requestDto.getContent() );
        }
        review.problem( problem );

        return review.build();
    }

    @Override
    public Review toEntity(Long id, ReviewRequestDto requestDto) {
        if ( id == null && requestDto == null ) {
            return null;
        }

        Review.ReviewBuilder review = Review.builder();

        if ( requestDto != null ) {
            review.content( requestDto.getContent() );
        }
        review.id( id );

        return review.build();
    }
}
