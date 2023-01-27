package wave.wwa.domain.problem.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wave.wwa.domain.common.ProblemMapper;
import wave.wwa.domain.problem.application.ProblemService;
import wave.wwa.domain.problem.dto.request.ProblemRequestDto;
import wave.wwa.domain.problem.dto.response.ProblemResponseDto;
import wave.wwa.domain.problem.repository.ProblemRepository;
import wave.wwa.global.dto.ResponseApiDto;

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

        return ResponseEntity.ok().body(ResponseApiDto.of(HttpStatus.OK,"ADD_PROBLEM_OK",problemId));
    }

    @GetMapping("/{problemId}")
    public ResponseEntity<?> getProblem(@PathVariable("problemId") Long problemId) {
        ProblemResponseDto responseDto = problemService.getProblem(problemId);

        return ResponseEntity.ok().body(ResponseApiDto.of(HttpStatus.OK,"GET_PROBLEM_OK",responseDto));
    }
}