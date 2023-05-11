package com.example.CustomerP.Service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.CustomerP.Entity.CustomerEntity;
import com.example.CustomerP.Repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

	
	private CustomerRepository customerRepository;
	
	@Override
	public Optional<CustomerEntity> customerById(Integer id) {
		// TODO Auto-generated method stub
		
		Optional<CustomerEntity>  customerEntityS = customerRepository.findById(id);
		
		return customerEntityS;
	}

	public Optional<CustomerEntity> updateCustomer(CustomerEntity customer, Integer id) {
		// TODO Auto-generated method stub
		
		Optional<CustomerEntity> customer1 = customerRepository.findById(id);
		
		Integer id1 = customer1.get().getId();
		
		
		customer1.get().setName(customer.getName());
		customer1.get().setEmail(customer.getEmail());
		customer1.get().setPhone(customer.getPhone());
		customer1.get().setAddress(customer.getAddress());
		
		return customer1;
	}

	@Override
	public CustomerEntity insertCustomerS(CustomerEntity customer) {
		// TODO Auto-generated method stub
		
		return customerRepository.save(customer);
		
	}

	@Override
	public String deleteCustomer(CustomerEntity customer) {
		// TODO Auto-generated method stub
		
		customerRepository.delete(customer);
		
		return "Customer Remove Successfully";
	}

	@Override
	public Optional<CustomerEntity> updateCustomer(CustomerEntity customer,String name, Integer id) {
		// TODO Auto-generated method stub
		
Optional<CustomerEntity> customer1 = customerRepository.findById(id);
		
		Integer id1 = customer1.get().getId();
		
		customer1.get().setName(customer.getName());
		
		return customer1;
	}

	@Override
	public Optional<CustomerEntity> updateCustomer(String email, CustomerEntity customer, Integer id) {
		// TODO Auto-generated method stub
Optional<CustomerEntity> customer1 = customerRepository.findById(id);
		
		Integer id1 = customer1.get().getId();
		
		customer1.get().setName(customer.getEmail());
		
		return customer1;
	}

	@Override
	public Optional<CustomerEntity> updateCustomer(CustomerEntity customer, Integer id, String phone) {
		// TODO Auto-generated method stub
		
Optional<CustomerEntity> customer1 = customerRepository.findById(id);
		
		Integer id1 = customer1.get().getId();
		
		customer1.get().setName(customer.getPhone());
		
		return customer1;
	}

	
}
