package com.example.capstone3.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String name;
    private Integer age;
    private String field;
    @ElementCollection
    private List<String> skills;
    private Boolean isBlacklist=false;
    private Integer experience;
    private String nationality;
    private Integer participationTimes;
    private Integer winningTimes;
    private String requestStatus="pending";
    @ElementCollection
    private List<String> hackathonWinNames;
    private String role;//member | leader
    @ManyToOne
    @JoinColumn(name = "team_id",referencedColumnName = "id")
    @JsonIgnore
    private Team team;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "member")
    private Set<Review> reviews;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "member")
    private Set<Request>requests;
}
