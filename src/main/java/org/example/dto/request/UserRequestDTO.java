package org.example.dto.request;
import org.example.entity.User;
import lombok.Getter;


@Getter
public class UserRequestDTO {
    private String cpf;


    private String name;


    private Integer age;

}
