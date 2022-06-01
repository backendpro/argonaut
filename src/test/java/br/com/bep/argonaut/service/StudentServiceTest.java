package br.com.bep.argonaut.service;

import br.com.bep.argonaut.dto.StudentDTO;
import br.com.bep.argonaut.persistence.model.Student;
import br.com.bep.argonaut.persistence.repository.StudentRepository;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;

@SpringBootTest
@Sql(executionPhase = BEFORE_TEST_METHOD, scripts = {"classpath:populate-database.sql"})
public class StudentServiceTest {

    @Autowired
    private StudentService service;

    @Autowired
    private StudentRepository repository;

    @BeforeAll
    public static void setUp() {
        FixtureFactoryLoader.loadTemplates("br.com.bep.argonaut.fixture");
    }

    @Test
    public void shouldCreateStudent() {
        StudentDTO request = Fixture.from(StudentDTO.class).gimme("valid");
        Optional<StudentDTO> response = service.create(request);

        assertNotNull(response.get());
        assertEquals(request.getName(), response.get().getName());
        assertEquals(request.getEmail(), response.get().getEmail());
        assertEquals(request.getAddressLine(), response.get().getAddressLine());
        assertEquals(request.getStudentSince(), response.get().getStudentSince());
        assertEquals(request.getCellphone(), response.get().getCellphone());
        assertEquals(request.getBirthDate(), response.get().getBirthDate());
        assertEquals(request.getIdentityNumber(), response.get().getIdentityNumber());
        assertEquals(request.getLastPayDate(), response.get().getLastPayDate());
        assertEquals(request.getMonthlyBill(), response.get().getMonthlyBill());
        assertEquals(request.getPostalCode(), response.get().getPostalCode());
    }

    @Test
    public void shouldCreateStudentWithoutPaymentInformation() {
        StudentDTO request = Fixture.from(StudentDTO.class).gimme("valid");
        request.setMonthlyBill(0.0);
        request.setLastPayDate(null);
        Optional<StudentDTO> response = service.create(request);

        assertNotNull(response.get());
        assertEquals(request.getName(), response.get().getName());
        assertEquals(request.getEmail(), response.get().getEmail());
        assertEquals(request.getAddressLine(), response.get().getAddressLine());
        assertEquals(request.getStudentSince(), response.get().getStudentSince());
        assertEquals(request.getCellphone(), response.get().getCellphone());
        assertEquals(request.getBirthDate(), response.get().getBirthDate());
        assertEquals(request.getIdentityNumber(), response.get().getIdentityNumber());
        assertEquals(request.getPostalCode(), response.get().getPostalCode());
        assertEquals(response.get().getMonthlyBill(), 0.0);
        assertNull(response.get().getLastPayDate());
    }

    @Test
    public void shouldGetStudentById() {
        Student student = repository.findAll().get(0);
        Optional<StudentDTO> response = service.getById(student.getId());

        assertNotNull(response.get());
        assertEquals(student.getName(), response.get().getName());
        assertEquals(student.getEmail(), response.get().getEmail());
        assertEquals(student.getAddressLine(), response.get().getAddressLine());
        assertEquals(student.getStudentSince(), response.get().getStudentSince());
        assertEquals(student.getCellphone(), response.get().getCellphone());
        assertEquals(student.getBirthdate(), response.get().getBirthDate());
        assertEquals(student.getIdentityNumber(), response.get().getIdentityNumber());
        assertEquals(student.getLastPayDate(), response.get().getLastPayDate());
        assertEquals(student.getMonthlyBill(), response.get().getMonthlyBill());
        assertEquals(student.getPostalCode(), response.get().getPostalCode());
    }

    @Test
    public void shouldGetAll() {
        Page<StudentDTO> responses = service.getAll(Pageable.ofSize(10));
        assertNotNull(responses.getContent());
        assertThat(responses.getContent().size(), greaterThan(0));
    }

    @Test
    public void shouldGetAllByStatusActive() {
        List<StudentDTO> responses = service.getByStatus(true);
        assertNotNull(responses);
        assertEquals(responses.size(), 1);
    }

    @Test
    public void shouldGetAllByStatusInactive() {
        List<StudentDTO> responses = service.getByStatus(false);
        assertNotNull(responses);
        assertEquals(responses.size(), 1);
    }

    @Test
    public void shouldGetByStatusEmptyList() {
        service.delete(3L);
        List<StudentDTO> responses = service.getByStatus(true);
        assertNotNull(responses);
        assertEquals(responses.size(), 0);
    }
}
