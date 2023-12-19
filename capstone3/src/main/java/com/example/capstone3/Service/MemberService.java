package com.example.capstone3.Service;

import com.example.capstone3.Api.ApiException;
import com.example.capstone3.Model.Member;
import com.example.capstone3.Model.Request;
import com.example.capstone3.Repository.MemberRepository;
import com.example.capstone3.Repository.RequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    public List<Member> getAllMembers(){
        return memberRepository.findAll();
    }
    public void addMember(Member member){
        memberRepository.save(member);
    }
    public void updateMember(Integer id,Member member){
        Member oldMember=memberRepository.findMemberById(id);
        if(oldMember==null){
            throw new ApiException("member not found");
        }
        oldMember.setEmail(member.getEmail());
        oldMember.setName(member.getName());
        oldMember.setAge(member.getAge());
        oldMember.setField(member.getField());
        oldMember.setSkills(member.getSkills());
        oldMember.setIsBlacklist(member.getIsBlacklist());
        oldMember.setExperience(member.getExperience());
        oldMember.setNationality(member.getNationality());
        oldMember.setParticipationTimes(member.getParticipationTimes());
        oldMember.setWinningTimes(member.getWinningTimes());
        oldMember.setRequestStatus(member.getRequestStatus());
        oldMember.setHackathonWinNames(member.getHackathonWinNames());
        oldMember.setRole(member.getRole());
        oldMember.setTeam(member.getTeam()); ////////////////

        memberRepository.save(oldMember);
    }
    public void deleteMember(Integer id){
        Member member=memberRepository.findMemberById(id);
        if(member==null){
            throw new ApiException("Member Not Found");
        }
        memberRepository.delete(member);
    }
}
