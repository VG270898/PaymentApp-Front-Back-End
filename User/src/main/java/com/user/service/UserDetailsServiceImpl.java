package com.user.service;

import com.user.model.Users;
import com.user.repository.RoleRepo;
import com.user.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

//    public Users registerCustomer(AuthenticationRequest authenticationRequest) {
////        authenticationRequest.setPassword(passwordEncoder.encode(authenticationRequest.getPassword()));
//        CustomerLogin customerLogin = new CustomerLogin();
//        customerLogin.setUsername(authenticationRequest.getUsername());
//        customerLogin.setPassword(authenticationRequest.getPassword());
//        return customerLoginRepo.save(customerLogin);
//
//    }


//    public Customer addCustomerDetails(CustomerDTO customerDTO,String username) {
//        Customer customer = new Customer();
//        customer.setCustomerId(customerLoginRepo.findByUsername(username).getCustomerId());
//        customer.setCustomerName(customerDTO.getCustomerName());
//        customer.setCustomerGender(customerDTO.getCustomerGender());
//        customer.setCustomerAge(customerDTO.getCustomerAge());
//        customer.setCustomerAddress(customerDTO.getCustomerAddress());
//
//        return customerRepo.save(customer);
//    }


    public Users findUserDetails(String loginId) throws Exception {
//        String customerId = userRepo.findByLoginId(loginId);

        if (userRepo.findByLoginId(loginId)==null) {
            throw new Exception("Customer Not Found with username " + loginId);
        } else {
            return userRepo.findByLoginId(loginId);
        }
    }
}
