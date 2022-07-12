package br.com.bep.argonaut.service;

import br.com.bep.argonaut.dto.StudentDTO;
import br.com.bep.argonaut.persistence.model.Student;
import br.com.bep.argonaut.persistence.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
        student.setActive(true);
        StudentDTO studentDTO =
                mapper.map(repository.saveAndFlush(student), StudentDTO.class);

        return Optional.of(studentDTO);
    }

    @Override
    public Optional<StudentDTO> getById(Long id) {
        Optional<Student> student = repository.findById(id);

        if (student.isPresent()) {
            StudentDTO dto = mapper.map(student.get(), StudentDTO.class);
            return Optional.of(dto);
        }
        return Optional.empty();
    }

    @Override
    public Page<StudentDTO> getAll(Pageable pageable) {
        return repository.findAll(pageable)
                .map(s -> mapper.map(s, StudentDTO.class));
    }

    @Override
    public boolean delete(Long id) {
        Optional<Student> student = repository.findById(id);

        if (student.isPresent()) {
            student.get().setActive(false);
            repository.save(student.get());
            return true;
        }
        return false;
    }

    @Override
    public List<StudentDTO> getByStatus(boolean active) {
        List<Student> students = repository.findByActive(active);
        if (!students.isEmpty()) {
            List<StudentDTO> dtos = new ArrayList<>();
            students.forEach(student -> dtos.add(mapper.map(student, StudentDTO.class)));
            return dtos;
        }
        return Collections.emptyList();
    }
}
