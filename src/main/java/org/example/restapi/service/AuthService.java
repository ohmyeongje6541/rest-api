package org.example.restapi.service;

import org.example.restapi.dto.request.LoginRequest;
import org.example.restapi.dto.request.SignupRequest;
import org.example.restapi.dto.response.TokenResponse;
import org.example.restapi.dto.response.UserResponse;

public interface AuthService {
    UserResponse signUp(SignupRequest request);
    TokenResponse login(LoginRequest request);

}
