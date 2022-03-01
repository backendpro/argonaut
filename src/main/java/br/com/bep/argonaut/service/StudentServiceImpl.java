package br.com.bep.argonaut.service;

import br.com.bep.argonaut.dto.StudentDTO;
import br.com.bep.argonaut.persistence.model.Student;
import br.com.bep.argonaut.persistence.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public Optional<StudentDTO> create(StudentDTO dto) {
        Student student = mapper.map(dto, Student.class);

        return Optional.empty();
    }

    @Override
    public Optional<StudentDTO> getById(Long id) {
        Optional<Student> student = repository.findById(id);

        if (student.isPresent()) {
            StudentDTO dto = mapper.map(student, StudentDTO.class);
            return Optional.of(dto);
        }
        return Optional.empty();
    }
}
