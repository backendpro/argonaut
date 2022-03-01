package br.com.bep.argonaut.persistence.repository;

import br.com.bep.argonaut.persistence.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
