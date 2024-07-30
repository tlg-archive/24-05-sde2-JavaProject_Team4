package com.gotakeahike.takeahike.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "app_user")
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column
    private String password;

    @Column
    private String city;

    @Column
    private String state;

    @Column
    @Enumerated(EnumType.STRING)
    private Experience experience;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<Trail> favoritedTrails = new ArrayList<>();

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}