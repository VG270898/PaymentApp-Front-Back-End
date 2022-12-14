package com.user.controller;

import com.user.model.AuthenticationRequest;
import com.user.model.AuthenticationResponse;
import com.user.service.CustomUserDetailService;
import com.user.service.UserDetailsServiceImpl;
import com.user.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private CustomUserDetailService customUserDetailService;

    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    AuthenticationResponse authenticationResponse= new AuthenticationResponse();
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        System.out.println("In customer authentication");
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getLoginId(), authenticationRequest.getPassword()));
        } catch (BadCredentialsException e) {
            System.out.println(e.getMessage());
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = customUserDetailService.loadUserByUsername(authenticationRequest.getLoginId());
        System.out.println(authenticationRequest.getLoginId());
        final String jwt = jwtTokenUtil.generateToken(userDetails);
        System.out.println(jwt);
        authenticationResponse.setJwt(jwt);
        return ResponseEntity.ok(authenticationResponse.getJwt());
    }
//
//    @PostMapping("/register")
//    public ResponseEntity registerCustomers(@RequestBody AuthenticationRequest authenticationRequest){
//        return ResponseEntity.ok(userServiceImpl.registerCustomer(authenticationRequest));
//    }

    @GetMapping("/getuser")
    public ResponseEntity findCustomerByUsername() throws Exception {
        Object auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String loginId = ((UserDetails)auth).getUsername();
        return ResponseEntity.ok(userDetailsServiceImpl.findUserDetails(loginId));
    }

//    @PostMapping("/addDetails")
//    public ResponseEntity addCustomerDetails(@RequestBody @Valid CustomerDTO customerDTO){
//        Object auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        String username = ((UserDetails)auth).getUsername();
//        return ResponseEntity.ok(customerServiceImpl.addCustomerDetails(customerDTO,username));
//    }

}
