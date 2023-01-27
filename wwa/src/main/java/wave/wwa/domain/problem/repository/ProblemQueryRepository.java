package wave.wwa.domain.problem.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import wave.wwa.domain.problem.domain.Problem;

import java.util.List;

import static wave.wwa.domain.problem.domain.QProblem.problem;
import static wave.wwa.domain.tag.domain.QProblemTag.problemTag;

@Repository
public class ProblemQueryRepository extends QuerydslRepositorySupport {

    private final JPAQueryFactory queryFactory;

    public ProblemQueryRepository(JPAQueryFactory queryFactory) {
        super(Problem.class);
        this.queryFactory = queryFactory;
    }

    public List<Problem> findByTagName(String tagName, int size){
        return queryFactory
                .selectFrom(problem)
                .join(problemTag).on(problemTag.problem.eq(problem))
                .where(problemTag.tag.tagName.eq(tagName))
                .orderBy(problem.id.desc())
                .limit(size)
                .fetch();

    }

}