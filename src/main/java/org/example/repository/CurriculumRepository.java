package org.example.repository;
import org.example.entity.Curriculum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CurriculumRepository extends JpaRepository<Curriculum, Long> {
}
