package org.example.restapi.service;

import lombok.RequiredArgsConstructor;
import org.example.restapi.dto.response.UserResponse;
import org.example.restapi.entity.User;
import org.example.restapi.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponse findByUsername(String username) {
        User user = userRepository.findByUsername(username)
            .orElseThrow();
        return UserResponse.from(user);
    }
}
