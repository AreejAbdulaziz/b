package com.example.capstone3.Controller;

import com.example.capstone3.Model.Hackathon;
import com.example.capstone3.Service.HackathonService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/hackathon")
@RequiredArgsConstructor
public class HackathonController {
    private final HackathonService hackathonService;
    @GetMapping("/get")
    public ResponseEntity getAllHackathon(){
        return ResponseEntity.status(200).body(hackathonService.getAllHackathon());
    }
    @PostMapping("/add")
    public ResponseEntity addHackathon(@RequestBody@Valid Hackathon hackathon){
        hackathonService.addHackathon(hackathon);
        return ResponseEntity.status(200).body("Hackathon Added!");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateHackathon(@PathVariable Integer id,@RequestBody@Valid Hackathon hackathon){
        hackathonService.updateHackathon(id, hackathon);
        return ResponseEntity.status(200).body("Hackathon Updated!");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteHackathon(@PathVariable Integer id){
       hackathonService.deleteHackathon(id);
       return ResponseEntity.status(200).body("Hackathon Deleted!");
    }
    @PutMapping("/assign/{hackathonId}/{teamId}")
    public ResponseEntity assignTeamToHackathon(@PathVariable Integer hackathonId,@PathVariable Integer teamId){
        hackathonService.assignTeamToHackathon(hackathonId, teamId);
        return ResponseEntity.status(200).body("Team Assigned To Hackathon");
    }
}
