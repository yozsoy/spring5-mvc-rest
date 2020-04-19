package guru.springframework.bootstrap;

import guru.springframework.domain.Category;
import guru.springframework.domain.Customer;
import guru.springframework.domain.Vendor;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.CustomerRepository;
import guru.springframework.repositories.VendorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 9/24/17.
 * spring specific class which runs before the application started.
 */
@Component
public class Bootstrap implements CommandLineRunner {

    private CategoryRepository categoryRepository;
    private CustomerRepository customerRepository;
    private final VendorRepository vendorRepository;

    public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository, VendorRepository vendorRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Category fruits = new Category();
        fruits.setName("Fruits");

        Category dried = new Category();
        dried.setName("Dried");

        Category fresh = new Category();
        fresh.setName("Fresh");

        Category exotic = new Category();
        exotic.setName("Exotic");

        Category nuts = new Category();
        nuts.setName("Nuts");

        categoryRepository.save(fruits);
        categoryRepository.save(dried);
        categoryRepository.save(fresh);
        categoryRepository.save(exotic);
        categoryRepository.save(nuts);


        System.out.println("Categories Loaded = " + categoryRepository.count());

        Customer customer1 = new Customer();
        customer1.setFirstName("ali");
        customer1.setLastName("veli");
        customer1.setCustomerUrl("no url");

        Customer customer2 = new Customer();
        customer2.setFirstName("ali2");
        customer2.setLastName("veli2");
        customer2.setCustomerUrl("no url2");

        Customer customer3 = new Customer();
        customer3.setFirstName("ali3");
        customer3.setLastName("veli3");
        customer3.setCustomerUrl("no url3");

        Customer customer4 = new Customer();
        customer4.setFirstName("ali4");
        customer4.setLastName("veli4");
        customer4.setCustomerUrl("no url4");

        Customer customer5 = new Customer();
        customer5.setFirstName("ali5");
        customer5.setLastName("veli5");
        customer5.setCustomerUrl("no url5");

        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);
        customerRepository.save(customer4);
        customerRepository.save(customer5);

        System.out.println("Customers Loaded = " + customerRepository.count());

        Vendor vendor1 = new Vendor();
        vendor1.setName("Vendor 1");
        vendorRepository.save(vendor1);

        Vendor vendor2 = new Vendor();
        vendor2.setName("Vendor 2");
        vendorRepository.save(vendor2);
    }
}
