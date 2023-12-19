package com.example.capstone3.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProjectDTO {
    private Integer team_id;
    private Integer committee_id;
    private String name;
    private String idea;
}
