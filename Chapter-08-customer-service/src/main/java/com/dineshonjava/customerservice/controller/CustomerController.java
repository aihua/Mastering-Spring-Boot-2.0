package com.dineshonjava.customerservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dineshonjava.customerservice.domain.Customer;
import com.dineshonjava.customerservice.repository.CustomerRepository;
import com.dineshonjava.customerservice.service.AccountService;

/**
 * @author Dinesh.Rajput
 *
 */
@RestController
public class CustomerController {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	AccountService accountService;  
	
	@PostMapping(value = "/customer")
	public Customer save (@RequestBody Customer customer){
		return customerRepository.save(customer);
	}
	
	@GetMapping(value = "/customer")
	public Iterable<Customer> all (){
		return customerRepository.findAll();
	}
	
	@GetMapping(value = "/customer/{customerId}")
	public Customer findByAccountId (@PathVariable Integer customerId){
		Customer customer = customerRepository.findByCustomerId(customerId);
		customer.setAccount(accountService.findByCutomer(customerId));
		return customer;
	}
	
	@PutMapping(value = "/customer")
	public Customer update (@RequestBody Customer customer){
		return customerRepository.save(customer);
	}
	
	@DeleteMapping(value = "/customer")
	public void delete (@RequestBody Customer customer){
		customerRepository.delete(customer);
	}
	
	/*@GetMapping(value = "/customer/account-type/{type}")
	public List<Customer> findByAccountType (@PathVariable String type){
		return customerRepository.findAllByAccountType(type);
	}
	
	@GetMapping(value = "/customer/bank/{bank}")
	public List<Customer> findByBank (@PathVariable String bank){
		return customerRepository.findByBank(bank);
	}
	
	@GetMapping(value = "/customer/account/{customer}")
	public List<Customer> findByBank (@PathVariable Integer customer){
		return customerRepository.findAllByCustomerId(customer);
	}*/
}