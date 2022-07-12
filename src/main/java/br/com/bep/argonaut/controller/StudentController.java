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

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> get(@PathVariable("id") Long id) {
        Optional<StudentDTO> response = service.getById(id);
        if (response.isPresent()) {
            return ResponseEntity.ok(response.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    /**
     * Delete físico: quando queremos remover 100% do contexto da aplicação. Sendo assim, removemos da base de dados.
     * Delete lógico: quando queremo remover da visualização da aplicação. Aí temos algum campo para filtramos os registros.
     * Ex.: active, deleted_at
     */

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
        boolean deleted = service.delete(id);
        return ResponseEntity.ok(deleted);
    }

    //TODO DESAFIO DA LIVE É IMPLEMENTAR O ENDPOINT DO GETBYSTATUS();
}
