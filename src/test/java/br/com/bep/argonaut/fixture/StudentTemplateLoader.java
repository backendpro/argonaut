package br.com.bep.argonaut.fixture;

import br.com.bep.argonaut.dto.StudentDTO;
import br.com.bep.argonaut.persistence.model.Student;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

import java.time.LocalDate;

public class StudentTemplateLoader implements TemplateLoader {

    @Override
    public void load() {
        Fixture.of(StudentDTO.class).addTemplate("valid", new Rule() {{
            add("name", random("Caio", "Will", "Eleven", "Mike"));
            add("identityNumber", "1238589");
            add("studentSince", LocalDate.now());
            add("birthDate", LocalDate.now());
            add("cellphone", 1234567894L);
            add("email", "email@email.com.br");
            add("postalCode", "13123456");
            add("addressLine", random("Rua A, bairro B", "Rua Sete, Bairro Loucura Bicho"));
            add("monthlyBill", random(Double.class, range(199.90, 999.99)));
            add("lastPayDate", LocalDate.now());
        }});
        Fixture.of(Student.class).addTemplate("valid-entity", new Rule() {{
            add("id", 1L);
            add("name", "Caio");
            add("identityNumber", "1238589");
            add("studentSince", LocalDate.now());
            add("birthDate", LocalDate.now());
            add("cellphone", 1234567894L);
            add("email", "email@email.com.br");
            add("postalCode", "13123456");
            add("addressLine", "Rua A, bairro B");
            add("monthlyBill", 199.90);
            add("lastPayDate", LocalDate.now());
        }});
    }
}
