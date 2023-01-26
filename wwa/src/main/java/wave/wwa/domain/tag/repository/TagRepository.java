package wave.wwa.domain.tag.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wave.wwa.domain.tag.domain.Tag;

import java.util.Optional;

public interface TagRepository extends JpaRepository<Tag, Long> {


    Optional<Tag> findByTagName(String tagName);
}