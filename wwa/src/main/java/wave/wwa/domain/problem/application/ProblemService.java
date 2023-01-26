package wave.wwa.domain.problem.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wave.wwa.domain.common.ProblemMapper;
import wave.wwa.domain.common.ReviewMapper;
import wave.wwa.domain.problem.domain.Problem;
import wave.wwa.domain.problem.dto.request.ProblemRequestDto;
import wave.wwa.domain.problem.repository.ProblemRepository;
import wave.wwa.domain.review.domain.Review;
import wave.wwa.domain.tag.domain.ProblemTag;
import wave.wwa.domain.tag.domain.Tag;
import wave.wwa.domain.tag.repository.TagRepository;

import java.util.List;

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
        List<ProblemTag> problemTagList = requestDto.getTagList().stream().map(tagName -> tagRepository.findByTagName(tagName)
                        .map(tag -> new ProblemTag(problem, tag)).orElseGet(
                                () -> new ProblemTag(problem, new Tag(tagName))
                        )).toList();

        problem.setProblemTagList(problemTagList);
        problem.setReview(review);
        Problem savedProblem = problemRepository.save(problem);
        return savedProblem.getId();
    }
}
