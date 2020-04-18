package guru.springfamework.services;

import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.domain.Customer;

import java.util.List;

public interface CustomerService {

    List<CustomerDTO> getAllCustomers();

    CustomerDTO createNewCustomer(CustomerDTO customerDTO);

    CustomerDTO saveCustomerByDTO(Long id, CustomerDTO customerDTO);

    CustomerDTO getCustomerById(Long id);

    CustomerDTO getCustomerByFirstName(String firstName);

    CustomerDTO patchCustomer(Long id, CustomerDTO customerDTO);
}
