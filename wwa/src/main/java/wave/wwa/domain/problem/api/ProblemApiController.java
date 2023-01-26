package wave.wwa.domain.problem.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wave.wwa.domain.common.ProblemMapper;
import wave.wwa.domain.problem.application.ProblemService;
import wave.wwa.domain.problem.dto.request.ProblemRequestDto;
import wave.wwa.domain.problem.repository.ProblemRepository;
import wave.wwa.global.dto.ResponseDto;

@RestController
@RequestMapping("/api/problems")
@RequiredArgsConstructor
public class ProblemApiController {

    private final ProblemService problemService;
    private final ProblemMapper problemMapper;
    private final ProblemRepository problemRepository;

    @PostMapping
    public ResponseEntity<?> addProblem(@RequestBody ProblemRequestDto requestDto) {
        Long problemId = problemService.addProblem(requestDto);

        return ResponseEntity.ok().body(ResponseDto.of(HttpStatus.OK,"ADD_PROBLEM_OK",problemId));
    }
}