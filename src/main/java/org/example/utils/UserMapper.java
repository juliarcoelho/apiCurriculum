package org.example.utils;

import org.example.dto.request.UserRequestDTO;
import org.example.dto.response.UserResponseDTO;
import org.example.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    public User toUser(UserRequestDTO userDTO) {
        return User.builder()
                .name(userDTO.getName())
                .cpf(userDTO.getCpf())
                .age(userDTO.getAge())
                .build();
    }

    public UserResponseDTO toUserDTO(User user) {
        return new UserResponseDTO(user);
    }

    public List<UserResponseDTO> toUserDTOList(List<User> userList) {
        return userList.stream().map(UserResponseDTO::new).collect(Collectors.toList());
    }

    public void updateUserData(User user, UserRequestDTO userDTO) {
        user.setName(userDTO.getName());
        user.setCpf(userDTO.getCpf());
        user.setAge(userDTO.getAge());
    }
}
