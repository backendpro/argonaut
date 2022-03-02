package br.com.bep.argonaut.service;

import br.com.bep.argonaut.dto.StudentDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    Optional<StudentDTO> create(StudentDTO dto);

    Optional<StudentDTO> getById(Long id);

    Page<StudentDTO> getAll(Pageable pageable);

    boolean delete(Long id);

    List<StudentDTO> getByStatus(boolean active);
}
