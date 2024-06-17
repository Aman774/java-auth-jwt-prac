package com.artisthub.space.controllers;

import com.artisthub.space.entity.User;
import com.artisthub.space.models.LoginResponse;
import com.artisthub.space.models.LoginUser;
import com.artisthub.space.models.RegisterUser;
import com.artisthub.space.services.AuthenticationService;
import com.artisthub.space.services.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    private final JwtService jwtService;

    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody RegisterUser registerUserDto) {
        User registeredUser = authenticationService.signup(registerUserDto);

        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUser loginUserDto) {
        try {
            User authenticatedUser = authenticationService.authenticate(loginUserDto);


            String jwtToken = jwtService.generateToken(authenticatedUser);

            LoginResponse loginResponse = new LoginResponse();

            loginResponse.setToken(jwtToken);
            loginResponse.setExpiresIn(jwtService.getExpirationTime());


            return ResponseEntity.ok(loginResponse);

        }
        catch(Exception e){
            System.out.println("error in login-----"+e.getMessage());
            System.out.println("test");
      return ResponseEntity.ok(new LoginResponse("113131",121212));
        }

    }
}