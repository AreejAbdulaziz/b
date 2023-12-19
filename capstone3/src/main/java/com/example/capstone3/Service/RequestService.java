package com.example.capstone3.Service;

import com.example.capstone3.Api.ApiException;
import com.example.capstone3.Model.Member;
import com.example.capstone3.Model.Request;
import com.example.capstone3.Model.Team;
import com.example.capstone3.Repository.MemberRepository;
import com.example.capstone3.Repository.RequestRepository;
import com.example.capstone3.Repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestService {
    private final RequestRepository requestRepository;
    private final MemberRepository memberRepository;
    private final TeamRepository teamRepository;

    public List<Request> getAllRequests(){
        return requestRepository.findAll();
    }
    public void addRequest(Request request){
        Member member=memberRepository.findMemberById(request.getMember().getId());
        Team team=teamRepository.findTeamById(request.getTeam().getId());
        Request request1=requestRepository.findRequestByMember(member);
        if(member==null||team==null){
            throw new ApiException("member or team is null, request cannot be created");
        }
        if(member.getTeam().getId()!=null){
            throw new ApiException("You Are Already In Team!");
        }
        if(request1.getTeam()==team){
            throw new ApiException("You Already Sent Request For This Team!");
        }
        request.setStatus("Pending");
        requestRepository.save(request);
    }
    public void deleteRequest(Integer id){
        Request request=requestRepository.findRequestById(id);
        if(request==null){
            throw new ApiException("Request Not Found");
        }
        requestRepository.delete(request);
    }
}
