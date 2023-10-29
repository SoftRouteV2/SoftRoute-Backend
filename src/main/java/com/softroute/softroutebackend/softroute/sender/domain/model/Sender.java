package com.softroute.softroutebackend.softroute.sender.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@With
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="sender")
public class Sender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long senderId;

    @NotNull
    @Column(name = "fullname", nullable = false)
    @Size(max = 75)
    private String fullname;

    @NotBlank
    @Column(name = "dni", nullable = false)
    @Size(max = 8)
    private String dni;
}
