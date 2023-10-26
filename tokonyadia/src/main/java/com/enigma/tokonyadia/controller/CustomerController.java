package com.enigma.tokonyadia.controller;

import com.enigma.tokonyadia.entity.Customer;
import com.enigma.tokonyadia.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/customer")
    public Customer createNewCustomer(@RequestBody Customer customer){
        return customerService.create(customer);
    }

}
