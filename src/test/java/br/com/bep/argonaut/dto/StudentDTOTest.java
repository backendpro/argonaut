package br.com.bep.argonaut.dto;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSettersExcluding;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentDTOTest {

    @Test
    public void dtoLocalDateDataTest() {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentSince(LocalDate.now());
        studentDTO.setBirthDate(LocalDate.now());
        studentDTO.setLastPayDate(LocalDate.now());

        assertEquals(LocalDate.now(), studentDTO.getStudentSince());
        assertEquals(LocalDate.now(), studentDTO.getBirthDate());
        assertEquals(LocalDate.now(), studentDTO.getLastPayDate());
    }

    @Test
    public void dtoObjectTest() {
        assertThat(StudentDTO.class, allOf(hasValidGettersAndSettersExcluding("studentSince", "lastPayDate", "birthDate")));
    }
}
