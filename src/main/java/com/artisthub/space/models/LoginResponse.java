package com.artisthub.space.models;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LoginResponse {
    private String token;

    private long expiresIn;


}
