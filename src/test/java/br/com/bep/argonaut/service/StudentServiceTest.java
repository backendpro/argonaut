package br.com.bep.argonaut.service;

import br.com.bep.argonaut.dto.StudentDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StudentServiceTest {

    @Autowired
    private StudentService service;

    StudentDTO request;

    @BeforeEach
    public void setUp(){
        request = new StudentDTO();
        request.setName("Caio");
        request.setEmail("email@email.com");
        request.setIdentityNumber("123456789");
        request.setPostalCode("1245788");
        request.setAddressLine("Rua das ruas, 135, SP");
        request.setStudentSince(LocalDate.now());
        request.setBirthDate(LocalDate.now());
        request.setCellphone(1155478962L);
        request.setMonthlyBill(150.00);
        request.setLastPayDate(LocalDate.now());
    }

    @Test
    public void shouldCreateStudent() {

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
}
