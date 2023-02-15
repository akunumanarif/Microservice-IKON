package com.ikon.authservice.service.impl;

import com.ikon.authservice.dto.UserDTO;
import com.ikon.authservice.entity.UserEntity;
import com.ikon.authservice.entity.UserSecurity;
import com.ikon.authservice.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class JpaUserDetailService implements UserDetailsService {
    private final AuthRepository userRepository;

    private final ModelMapper modelMapper;

    @Override
    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {
        Optional<UserEntity> user = userRepository.findByPhone(phone);
        if(user.isPresent()) {
            return new UserSecurity(user.get());
        }
        throw new UsernameNotFoundException("username not found");
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<UserEntity> user = userRepository.findByUsername(username);
//        if(user.isPresent()) {
//            return new UserSecurity(user.get());
//        }
//        throw new UsernameNotFoundException("username not found");
//    }

    public List<UserDTO> getAll() {

        List<UserEntity> users = userRepository.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();

        for(UserEntity user : users) {
            userDTOList.add(modelMapper.map(user, UserDTO.class));
        }

        return userDTOList;
    }


}

