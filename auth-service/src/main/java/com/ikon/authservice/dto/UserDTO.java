package com.ikon.authservice.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class UserDTO {
    private Long id;
    private String username;
    private String phone;
    private String email;
    private String password;
    private String name;
    private String role;

}
