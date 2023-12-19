package com.example.capstone3.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL , mappedBy = "team")
    @PrimaryKeyJoinColumn
    private Project project;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "team")
    private Set<Member> members;

    @ManyToOne
    @JoinColumn(name = "hackathon_id",referencedColumnName = "id")
    @JsonIgnore
    private Hackathon hackathon;

    @OneToOne(cascade = CascadeType.ALL , mappedBy = "team")
    @PrimaryKeyJoinColumn
    private Request request;

}
