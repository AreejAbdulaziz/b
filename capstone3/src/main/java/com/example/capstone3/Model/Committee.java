package com.example.capstone3.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Committee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String userName;
    private String email;// جيب لي اللي اليوزر و الايميل سويها كويري
    private String name;
    private String comment;
    private double grade;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "committee")
    private Set<Project> projects; //عشان الربط بس
}
