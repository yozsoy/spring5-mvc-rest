package guru.springframework.repositories;

import guru.springframework.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jt on 9/24/17.
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByFirstName(String firstName);
    Customer findByLastName(String lastName);
    Customer findByCustomerUrl(String url);
}
