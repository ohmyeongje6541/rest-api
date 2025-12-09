package org.example.restapi.service;

import org.example.restapi.dto.response.UserResponse;

public interface UserService {
    UserResponse findByUsername(String username);
}
