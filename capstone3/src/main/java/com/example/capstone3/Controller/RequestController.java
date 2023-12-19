package com.example.capstone3.Controller;

import com.example.capstone3.Model.Request;
import com.example.capstone3.Service.RequestService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/request")
@RequiredArgsConstructor
public class RequestController {
    private final RequestService requestService;
    @GetMapping("/get")
    public ResponseEntity getAllRequests(){
        return ResponseEntity.status(200).body(requestService.getAllRequests());
    }
    @PostMapping("/add")
    public ResponseEntity addRequest(@RequestBody@Valid Request request){
        requestService.addRequest(request);
        return ResponseEntity.status(200).body("Request Added");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteRequest(@PathVariable Integer id){
        requestService.deleteRequest(id);
        return ResponseEntity.status(200).body("Request Deleted");
    }
}
