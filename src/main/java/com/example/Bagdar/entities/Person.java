package com.example.Bagdar.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @ManyToOne(fetch = FetchType.EAGER)
    private Department department;

}
