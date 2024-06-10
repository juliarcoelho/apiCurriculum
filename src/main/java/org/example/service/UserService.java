package org.example.service;
import org.example.dto.request.UserRequestDTO;
import org.example.dto.response.UserResponseDTO;
import java.util.List;
public interface UserService {
    UserResponseDTO getUserById(Long id);

    List<UserResponseDTO> getAllUsers();

    UserResponseDTO register(UserRequestDTO UserDTO);

    UserResponseDTO update( Long id, UserRequestDTO UserDTO);

    String delete (Long id);
}
