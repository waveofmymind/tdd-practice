package wave.wwa.domain.problem.domain;

import jakarta.persistence.*;

@Entity
@Table(name="problem")
public class Problem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="problem_id")
    private Long id;
    @Column(name="title")
    private String title;
    @Column(name="step")
    private int step;
    @Column(name="link")
    private String link;
}
