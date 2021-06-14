package br.com.digitalhouse.desafioquality;

import br.com.digitalhouse.desafioquality.repository.DistrictRepository;
import br.com.digitalhouse.desafioquality.service.exceptions.NotFoundException;
import br.com.digitalhouse.desafioquality.service.exceptions.ValidationException;
import br.com.digitalhouse.desafioquality.service.validation.ValidationRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RepositoryTests {

    @Test
    void shouldGetDistrictValue () {
        double districtValueExp = 11654;

        double districtValue = DistrictRepository.findByName("Moema").getValue();

        Assertions.assertEquals(districtValueExp,districtValue);
    }

    @Test
    void shouldThrowNotFoundException () {

        Exception ex = Assertions.assertThrows(NotFoundException.class, () -> DistrictRepository.findByName("Moemax").getValue());
        Assertions.assertEquals("Nome do bairro não encontrado.",ex.getMessage());
    }
}
