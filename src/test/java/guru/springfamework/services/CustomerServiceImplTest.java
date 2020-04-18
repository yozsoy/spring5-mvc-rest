package guru.springfamework.services;

import guru.springfamework.api.v1.mapper.CustomerMapper;
import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.domain.Category;
import guru.springfamework.domain.Customer;
import guru.springfamework.repositories.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


public class CustomerServiceImplTest {

    CustomerService customerService;

    @Mock
    CustomerRepository customerRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        customerService = new CustomerServiceImpl(CustomerMapper.INSTANCE, customerRepository);
    }

    @Test
    public void getAllCustomers() {
        //given
        List<Customer> customers = Arrays.asList(new Customer(), new Customer(), new Customer());

        when(customerRepository.findAll()).thenReturn(customers);

        //when
        List<CustomerDTO> customerDtos = customerService.getAllCustomers();

        //then
        assertEquals(3, customerDtos.size());
    }

    @Test
    public void getCustomerByFirstName() {
        //given
        Customer customer = new Customer();
        customer.setFirstName("Yilmaz");
        customer.setLastName("Ozsoy");

        when(customerRepository.findByFirstName(anyString())).thenReturn(customer);

        //when
        CustomerDTO fetchedCustomer = customerService.getCustomerByFirstName("Yilmaz");

        //then
        assertEquals("Yilmaz", fetchedCustomer.getFirstName());
        assertEquals("Ozsoy", fetchedCustomer.getLastName());





    }
}
