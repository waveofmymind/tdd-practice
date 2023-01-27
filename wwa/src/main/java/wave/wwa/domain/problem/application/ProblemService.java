package wave.wwa.domain.problem.application;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wave.wwa.domain.common.ProblemMapper;
import wave.wwa.domain.common.ReviewMapper;
import wave.wwa.domain.problem.domain.Problem;
import wave.wwa.domain.problem.dto.request.ProblemRequestDto;
import wave.wwa.domain.problem.dto.response.ProblemResponseDto;
import wave.wwa.domain.problem.repository.ProblemRepository;
import wave.wwa.domain.review.domain.Review;
import wave.wwa.domain.tag.domain.ProblemTag;
import wave.wwa.domain.tag.domain.Tag;
import wave.wwa.domain.tag.repository.TagRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ProblemService {
    private final TagRepository tagRepository;

    private final ProblemRepository problemRepository;
    private final ProblemMapper problemMapper;

    private final ReviewMapper reviewMapper;

    public Long addProblem(ProblemRequestDto requestDto) {
        Problem problem = problemMapper.toEntity(requestDto);
        Review review = reviewMapper.toEntity(requestDto, problem);
        //tagName으로 Tag객체를 찾아 ProblemTag로 매핑, 만약 Tag가 null일 경우, Tag 객체 tagName으로 생성해서 ProblemTag 생성
        List<ProblemTag> problemTagList = requestDto.getTagList().stream().map(tagName -> tagRepository.findByTagName(tagName)
                        .map(tag -> new ProblemTag(problem, tag)).orElseGet(
                                () -> new ProblemTag(problem, new Tag(tagName))
                        )).toList();

        problem.setProblemTagList(problemTagList);
        problem.setReview(review);

        Problem savedProblem = problemRepository.save(problem);
        return savedProblem.getId();
    }

    public ProblemResponseDto getProblem(Long problemId) {
        Problem problem = problemRepository.findById(problemId).orElseThrow(EntityNotFoundException::new);

        return problemMapper.toDto(problem);
    }
}
