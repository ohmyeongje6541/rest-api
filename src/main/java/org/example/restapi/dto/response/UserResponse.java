package org.example.restapi.dto.response;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import org.example.restapi.entity.User;

@Getter
@Builder
public class UserResponse {
    private Long id;
    private String username;
    private String email;
    private String name;
    private LocalDateTime createdAt;

    public static UserResponse from(User user) {
        return UserResponse.builder()
            .id(user.getId())
            .username(user.getUsername())
            .email(user.getEmail())
            .name(user.getName())
            .createdAt(user.getCreatedAt())
            .build();
    }

}
