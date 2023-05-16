package com.wom.sites.token;

import com.wom.sites.usuarios.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Token {

    @Id
    @GeneratedValue
    private Integer id;

    private String token;

    @Enumerated(EnumType.STRING)
    private TookenType tokenType;

    private boolean expired;

    private boolean revoked;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
