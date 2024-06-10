package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "cpf", nullable = false, unique = true)
    private String cpf;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "age")
    private Integer age;
}
