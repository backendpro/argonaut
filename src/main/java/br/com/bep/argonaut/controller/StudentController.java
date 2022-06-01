package br.com.bep.argonaut.controller;

import br.com.bep.argonaut.dto.StudentDTO;
import br.com.bep.argonaut.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/argonauts")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping
    public ResponseEntity<StudentDTO> create(@RequestBody StudentDTO request) {
        Optional<StudentDTO> response = service.create(request);
        if (response.isPresent()) {
            return new ResponseEntity<>(response.get(), HttpStatus.CREATED);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping
    public ResponseEntity<Page<StudentDTO>> getAll(Pageable pageable) {
        Page<StudentDTO> responses = service.getAll(pageable);
        return ResponseEntity.ok(responses);
    }
}
