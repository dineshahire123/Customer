package com.example.CustomerP.Service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.CustomerP.Entity.CustomerEntity;

@Service
public interface CustomerService {

	Optional<CustomerEntity> customerById(Integer id);

	Optional<CustomerEntity> updateCustomer(CustomerEntity customer, Integer id);

    CustomerEntity insertCustomerS(CustomerEntity customer);

    String deleteCustomer(CustomerEntity customer);

	Optional<CustomerEntity> updateCustomer(CustomerEntity customer,String name, Integer id);

	Optional<CustomerEntity> updateCustomer(String email, CustomerEntity customer, Integer id);

	Optional<CustomerEntity> updateCustomer(CustomerEntity customer, Integer id, String phone);

}
