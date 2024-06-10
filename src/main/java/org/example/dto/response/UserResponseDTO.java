package org.example.dto.response;
import org.example.entity.User;
import lombok.Getter;
@Getter
public class UserResponseDTO {
    private Long id;


    private String cpf;


    private String name;


    private Integer age;

    public UserResponseDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.age = user.getAge();
        this.cpf = user.getCpf();
    }
}
