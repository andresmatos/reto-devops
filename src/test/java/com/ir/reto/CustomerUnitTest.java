package com.ir.reto;

import com.ir.reto.entities.Customer;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CustomerUnitTest {
    @Test
    public void whenCalledGetName_thenCorrect() {
        Customer customer = new Customer("Julie", "julie@domain.com");

        assertThat(customer.getName()).isEqualTo("Julie");
    }

    @Test
    public void whenCalledGetEmail_thenCorrect() {
        Customer customer = new Customer("Julie", "julie@domain.com");

        assertThat(customer.getEmail()).isEqualTo("julie@domain.com");
    }

    @Test
    public void whenCalledSetName_thenCorrect() {
        Customer customer = new Customer("Julie", "julie@domain.com");

        customer.setName("John");

        assertThat(customer.getName()).isEqualTo("John");
    }

    @Test
    public void whenCalledSetEmail_thenCorrect() {
        Customer customer = new Customer("Julie", "julie@domain.com");

        customer.setEmail("john@domain.com");

        assertThat(customer.getEmail()).isEqualTo("john@domain.com");
    }

    @Test
    public void whenCalledtoString_thenCorrect() {
        Customer customer = new Customer("Julie", "julie@domain.com");
        assertThat(customer.toString()).isEqualTo("Customer{id=0, name=Julie, email=julie@domain.com}");
    }
}
