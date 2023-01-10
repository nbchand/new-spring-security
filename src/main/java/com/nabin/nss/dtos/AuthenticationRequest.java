package com.nabin.nss.dtos;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Narendra
 * @version 1.0
 * @since 2023-01-09
 */
@Getter
@Setter
public class AuthenticationRequest {
    private String email;
    private String password;
}
