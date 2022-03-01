package br.com.bep.argonaut.service;

import br.com.bep.argonaut.dto.StudentDTO;

import java.util.Optional;

public interface StudentService {

    Optional<StudentDTO> create(StudentDTO dto);

    Optional<StudentDTO> getById(Long id);
}
