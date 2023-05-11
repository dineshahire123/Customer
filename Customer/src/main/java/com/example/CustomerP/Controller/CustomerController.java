package com.example.CustomerP.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CustomerP.Entity.CustomerEntity;
import com.example.CustomerP.Service.CustomerService;
import com.example.CustomerP.Service.CustomerServiceImpl;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerServiceImpl customerServiceImpl;
	

	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<CustomerEntity>> CustomerDetailsById(@PathVariable("id") Integer id)
	{
		
		Optional<CustomerEntity> customerE = customerServiceImpl.customerById(id);
		return new ResponseEntity<Optional<CustomerEntity>>(customerE,HttpStatus.ACCEPTED);
		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Optional<CustomerEntity>> updateCustomer(CustomerEntity customer,@PathVariable("id") Integer id)
	{
		Optional<CustomerEntity> updateCustomer = customerServiceImpl.updateCustomer(customer,id);
		
		return new ResponseEntity<Optional<CustomerEntity>>(updateCustomer,HttpStatus.OK);
	}
	
	@PatchMapping("/update/{id}/{name}")
	public ResponseEntity<Optional<CustomerEntity>> updateCustomer(CustomerEntity customer,@PathVariable("name") String name,Integer id)
	{
		Optional<CustomerEntity> updateCustomer = customerServiceImpl.updateCustomer(customer,name,id);
		
		return new ResponseEntity<Optional<CustomerEntity>>(updateCustomer,HttpStatus.OK);
	}
	
	@PatchMapping("/email/{id}/{email}")
	public ResponseEntity<Optional<CustomerEntity>> updateCustomer(@PathVariable("email") String email,CustomerEntity customer,Integer id)
	{
		Optional<CustomerEntity> updateCustomer = customerServiceImpl.updateCustomer(email,customer,id);
		
		return new ResponseEntity<Optional<CustomerEntity>>(updateCustomer,HttpStatus.OK);
	}
	
	
	@PatchMapping("/phone/{id}/{phone}")
	public ResponseEntity<Optional<CustomerEntity>> updateCustomer(CustomerEntity customer,Integer id,@PathVariable("phone") String phone)
	{
		Optional<CustomerEntity> updateCustomer = customerServiceImpl.updateCustomer(customer,id, phone);
		
		return new ResponseEntity<Optional<CustomerEntity>>(updateCustomer,HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<CustomerEntity> InsertCustomer(@RequestBody CustomerEntity customer)
	{
		CustomerEntity customerI = customerServiceImpl.insertCustomerS(customer);
		
		return ResponseEntity.ok().body(customerI);
		
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> DeleteCustomer(CustomerEntity customer)
	{
	String message = customerServiceImpl.deleteCustomer(customer);
     
	return new ResponseEntity<String>(message,HttpStatus.ACCEPTED);
	}
	
	
	

}
