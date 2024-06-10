package org.example.entity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_curriculum")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Curriculum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "objective", nullable = false)
    private String objective;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Builder.Default
    @OneToMany(mappedBy = "curriculum", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Experience> experiences = new ArrayList<>();

}
