package wave.shop.domain.user.dto;

import wave.shop.domain.user.domain.User;

public record SignupDto(String username,
                        String password,
                        String email,
                        String name) {

    public User toEntity() {
        return User.builder()
                .username(username)
                .password(password)
                .email(email)
                .name(name)
                .build();
    }

}
