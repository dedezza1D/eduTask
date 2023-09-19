package com.edutask.edutaskservice.usermanagment;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // campo de ID adicionado

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private UUID keycloakId;
    private String name;
    private String email;
    private String role;

}