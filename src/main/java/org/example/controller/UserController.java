package org.example.controller;
import org.example.dto.request.UserRequestDTO;
import org.example.dto.response.UserResponseDTO;
import org.example.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserResponseDTO> findById(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok().body(userService.getUserById(id));
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> findAll() {
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> create(@RequestBody UserRequestDTO userRequestDTO, UriComponentsBuilder uriBuilder) {
        UserResponseDTO userResponseDTO = userService.register(userRequestDTO);
        URI uri = uriBuilder.path("/user'/{id}").buildAndExpand(userResponseDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(userResponseDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserResponseDTO> update(@RequestBody UserRequestDTO userDTO, @PathVariable(name = "id") Long id) {
        return  ResponseEntity.ok().body(userService.update(id, userDTO));
    }

    @DeleteMapping(value = "/{id}")
    public  ResponseEntity<String> delete(@PathVariable(name = "id") Long id) {
        return  ResponseEntity.ok().body(userService.delete(id));
    }

}
