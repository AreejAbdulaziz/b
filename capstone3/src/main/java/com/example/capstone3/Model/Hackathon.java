package com.example.capstone3.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Hackathon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer min;
    private Integer max;
    private Integer prize;
    private String field;
    private Integer ageAllowed;
    private LocalDate startDate;
    private LocalDate endDate;
    private String companyName;
    private String city; //المكان اللي تقدمت فيه المسابقه
    private Boolean isOnline;
    private Integer winningTeamId=null; //id
    @ElementCollection
    private List<Integer> idTeams;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "hackathon")
    private Set<Team> teams;
}
