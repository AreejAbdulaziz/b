package com.example.capstone3.Controller;

import com.example.capstone3.DTO.TeamDTO;
import com.example.capstone3.Model.Member;
import com.example.capstone3.Model.Team;
import com.example.capstone3.Service.TeamService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/team")
@RequiredArgsConstructor
public class TeamController {
    private final TeamService teamService;
    @GetMapping("/get")
    public ResponseEntity getAllTeams(){
        return ResponseEntity.status(200).body(teamService.getAllTeams());
    }

    @PostMapping("/add")
    public ResponseEntity addTeam(@RequestBody@Valid TeamDTO teamDTO){
      teamService.addTeam(teamDTO);
      return ResponseEntity.status(200).body("Team Added");
    }
//    @PutMapping("/update/{member_id}")
//    public ResponseEntity updateTeam(@RequestBody@Valid Team team,@PathVariable Integer member_id){
//        teamService.updateTeam(team, member_id);
//        return ResponseEntity.status(200).body("Team Updated");
//    }
    @DeleteMapping("/delete/{team_id}/{member_id}")
    public ResponseEntity deleteTeam(@PathVariable Integer team_id,@PathVariable Integer member_id){
        teamService.deleteTeam(team_id, member_id);
        return ResponseEntity.status(200).body("Team Deleted");
    }
    //ينشال مفروش ركوست قبلها مش دايركت
//    @PutMapping("/assign/{team_id}/{member_id}")
//    public ResponseEntity assignMemberToTeam(@PathVariable Integer team_id,@PathVariable Integer member_id){
//        teamService.assignMemberToTeam(team_id, member_id);
//        return ResponseEntity.status(200).body("Member Assigned To Team");
//    }
}
