package com.ikon.authservice.controller;

import com.ikon.authservice.dto.ResponseDTO;
import com.ikon.authservice.dto.UserDTO;
import com.ikon.authservice.entity.UserEntity;
import com.ikon.authservice.repository.AuthRepository;
import com.ikon.authservice.service.TokenService;
import com.ikon.authservice.service.impl.JpaUserDetailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v2/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final AuthRepository userRepository;
    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;
    private final JpaUserDetailService jpaUserDetailService;
    @PostMapping("/register")
    public ResponseEntity<ResponseDTO> addUser(@RequestBody UserDTO userDTO) {
        tokenService.addUser(userDTO);
        return new ResponseEntity<ResponseDTO>(ResponseDTO.builder()
                .httpStatus(HttpStatus.CREATED)
                .message("success add user")
                .data(userDTO).build(), HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<ResponseDTO<String>> token(@RequestBody UserEntity user) {

//      Optional<UserEntity> userEntity = userRepository.findByPhone(user.getPhone());
//      log.info("UserEntity found in the database: {}", userEntity);
        log.info("User phone number: {}", user.getPhone());
        log.info("User password: {}", user.getPassword());
        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getPhone(), user.getPassword()));
        } catch (AuthenticationException e) {
            log.error("Error during authentication: {}", e.getMessage());
            throw new BadCredentialsException("Invalid phone number or password");
        }

        String token = tokenService.generatedToken(authentication);
        return new ResponseEntity(ResponseDTO.builder().httpStatus(HttpStatus.OK).message("token created").data(token).build(), HttpStatus.OK);

    }

    // old Method
//    @PostMapping("/login")
//    public ResponseEntity<ResponseDTO<String>> token(@RequestBody UserEntity user) {
//
//        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
//        String token = tokenService.generatedToken(authentication);
//        return new ResponseEntity(ResponseDTO.builder().httpStatus(HttpStatus.OK).message("token created").data(token).build(), HttpStatus.OK);
//
//    }
    @GetMapping("/user-data")
    public ResponseEntity<ResponseDTO<Object>> userInfo(@RequestHeader(name = "Authorization") String tokenBearer) {

        UserDTO user = tokenService.decodeToken(tokenBearer);

        //add deeper structure
        return new ResponseEntity(ResponseDTO.builder().httpStatus(HttpStatus.OK).message("token found").data(user).build(), HttpStatus.OK);
        // return user;
    }
    //user
    @GetMapping("/user-data-2")
    public ResponseEntity<UserDTO> userInfo2(@RequestHeader(name = "Authorization") String tokenBearer) {
        UserDTO user = tokenService.decodeToken(tokenBearer);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @GetMapping("/all-users")
    public ResponseEntity<List<UserDTO>> allUsers() {
        log.info("AuthController method allUsers");
        return new ResponseEntity<>(jpaUserDetailService.getAll(), HttpStatus.OK);
    }
}


