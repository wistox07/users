package org.fernando.users.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "user_data")
@Entity
public class User {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUser;

    @Column(length = 50 , nullable = false)
    private String username;

    @Column(length = 60 , nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean enabled;

}
