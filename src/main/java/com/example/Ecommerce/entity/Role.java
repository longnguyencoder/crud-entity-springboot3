package com.example.Ecommerce.entity;


import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;


import java.util.Set;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "role")
public class Role {
    @Id
    String name;
    String description;

//    @OneToMany(fetch = FetchType.LAZY)
    @ManyToMany
    Set<Permission> permissions;
}

