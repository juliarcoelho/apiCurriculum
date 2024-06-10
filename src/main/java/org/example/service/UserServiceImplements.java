package org.example.service;

import org.example.dto.request.UserRequestDTO;
import org.example.dto.response.UserResponseDTO;
import org.example.entity.User;
import org.example.repository.UserRepository;
import org.example.utils.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class UserServiceImplements implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponseDTO getUserById(Long id) {
        return userMapper.toUserDTO(returnUser(id));
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        return userMapper.toUserDTOList(userRepository.findAll());
    }

    @Override
    public UserResponseDTO register(UserRequestDTO userDTO) {
        User user = userMapper.toUser(userDTO);
        return userMapper.toUserDTO(userRepository.save(user));
    }

    @Override
    public UserResponseDTO update(Long id, UserRequestDTO userDTO) {
        User user = returnUser(id);
        userMapper.updateUserData(user, userDTO);
        return userMapper.toUserDTO(userRepository.save(user));
    }

    @Override
    public String delete(Long id) {
        userRepository.deleteById(id);
        return "User id: " + id + " deletado com sucesso!";
    }

    private User returnUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }
}
