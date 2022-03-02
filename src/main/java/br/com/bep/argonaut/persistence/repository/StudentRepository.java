package br.com.bep.argonaut.persistence.repository;

import br.com.bep.argonaut.persistence.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByActive(boolean active);
}
