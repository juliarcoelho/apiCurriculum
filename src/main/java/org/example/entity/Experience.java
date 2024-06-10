package org.example.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "tb_experience")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "company", nullable = false)
    private String company;

    @Column(name = "position", nullable = false)
    private String position;

    @Column(name = "description", nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "curriculum_id", nullable = false)
    @JsonBackReference
    private Curriculum curriculum;

    public Experience(String company, String position, String description, Curriculum curriculum) {
        this.company = company;
        this.position = position;
        this.description = description;
        this.curriculum = curriculum;
    }
}
