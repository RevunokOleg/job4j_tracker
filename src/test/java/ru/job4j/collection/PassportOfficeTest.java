package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PassportOfficeTest {
    @Test
    public void whenTestAddMethod() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport())).isEqualTo(citizen);
    }

    @Test
    public void whenTestAddMethodIsFalse() {
        Citizen citizenPetrov = new Citizen("123abbb", "Petr Petrov");
        Citizen citizenIvanov = new Citizen("123abbb", "Ivan Ivanov");
        PassportOffice office = new PassportOffice();
        office.add(citizenPetrov);
        office.add(citizenIvanov);
        assertThat(office.add(citizenIvanov)).isFalse();
    }
}