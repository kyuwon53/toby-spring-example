package com.example.tobyspring.user.domain;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    String id;
    String name;
    String password;
}
