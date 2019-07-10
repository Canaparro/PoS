package pos.customer;


import org.springframework.web.bind.annotation.*;
import pos.posts.PostRepository;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private CustomerRepository customerRepository;

    private PostRepository postRepository;

    public CustomerController(CustomerRepository customerRepository, PostRepository postRepository) {
        this.customerRepository = customerRepository;
        this.postRepository = postRepository;
    }

    @PostMapping
    public void createCustomer(@RequestBody Customer customer) {
        postRepository.saveAll(customer.getPosts());
        customerRepository.save(customer);
    }

    @GetMapping
    public Customer findCustomer(String firstName) {
        return customerRepository.findByFirstName(firstName);
    }

    @GetMapping("/all")
    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    @DeleteMapping
    public void deleteAllCustomers() {
        customerRepository.deleteAll();
    }
}
