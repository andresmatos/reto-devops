package com.ir.reto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.ir.reto.controllers.CustomerController;
import com.ir.reto.entities.Customer;
import com.ir.reto.repositories.CustomerRepository;

public class CustomerControllerUnitTest {

    private static CustomerController customerController;
    private static CustomerRepository mockedCustomerRepository;
    private static BindingResult mockedBindingResult;
    private static Model mockedModel;

    @BeforeClass
    public static void setUpCustomerControllerInstance() {
        mockedCustomerRepository = mock(CustomerRepository.class);
        mockedBindingResult = mock(BindingResult.class);
        mockedModel = mock(Model.class);
        customerController = new CustomerController(mockedCustomerRepository);
    }


    @Test
    public void whenCalledaddCustomerAndValidCustomer_thenCorrect() {
        Customer customer = new Customer("John", "john@domain.com");

        when(mockedBindingResult.hasErrors()).thenReturn(false);

        assertThat(customerController.addCustomer(customer, mockedBindingResult, mockedModel)).isEqualTo("index");
    }


    @Test(expected = IllegalArgumentException.class)
    public void whenCalledshowUpdateForm_thenIllegalArgumentException() {
        assertThat(customerController.showUpdateForm(0, mockedModel)).isEqualTo("update-customer");
    }

    @Test
    public void whenCalledupdateCustomerAndValidCustomer_thenCorrect() {
        Customer customer = new Customer("John", "john@domain.com");

        when(mockedBindingResult.hasErrors()).thenReturn(false);

        assertThat(customerController.updateCustomer(1l, customer, mockedBindingResult, mockedModel)).isEqualTo("index");
    }

    @Test
    public void whenCalledupdateCustomerAndInValidCustomer_thenCorrect() {
        Customer customer = new Customer("John", "john@domain.com");

        when(mockedBindingResult.hasErrors()).thenReturn(true);

        assertThat(customerController.updateCustomer(1l, customer, mockedBindingResult, mockedModel)).isEqualTo("update-customer");
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenCalleddeleteCustomer_thenIllegalArgumentException() {
        assertThat(customerController.deleteCustomer(1l, mockedModel)).isEqualTo("index");
    }
}
