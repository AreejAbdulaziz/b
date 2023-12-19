package com.example.capstone3.Controller;

import com.example.capstone3.Model.Member;
import com.example.capstone3.Service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    @GetMapping("/get")
    public ResponseEntity getAllMembers(){
        return ResponseEntity.status(200).body(memberService.getAllMembers());
    }
    @PostMapping("/add")
    public ResponseEntity addMember(@RequestBody@Valid Member member){
        memberService.addMember(member);
        return ResponseEntity.status(200).body("Member Added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateMember(@PathVariable Integer id,@RequestBody@Valid Member member){
        memberService.updateMember(id, member);
        return ResponseEntity.status(200).body("Member Updated");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMember(@PathVariable Integer id){
        memberService.deleteMember(id);
        return ResponseEntity.status(200).body("Member Deleted!");
    }
}
