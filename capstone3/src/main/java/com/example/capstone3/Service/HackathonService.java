package com.example.capstone3.Service;

import com.example.capstone3.Api.ApiException;
import com.example.capstone3.Model.Hackathon;
import com.example.capstone3.Model.Team;
import com.example.capstone3.Repository.HackathonRepository;
import com.example.capstone3.Repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class HackathonService {
    private final HackathonRepository hackathonRepository;
    private final TeamRepository teamRepository;
    public List<Hackathon> getAllHackathon(){
        return hackathonRepository.findAll();
    }

    public void addHackathon(Hackathon hackathon){
        hackathonRepository.save(hackathon);
    }

    public void updateHackathon(Integer id,Hackathon hackathon){
        Hackathon oldHackathon=hackathonRepository.findHackathonById(id);
        if(oldHackathon==null){
            throw new ApiException("Hackathon not found");
        }
        oldHackathon.setName(hackathon.getName());
        oldHackathon.setName(hackathon.getName());
        oldHackathon.setMin(hackathon.getMin());
        oldHackathon.setMax(hackathon.getMax());
        oldHackathon.setPrize(hackathon.getPrize());
        oldHackathon.setAgeAllowed(hackathon.getAgeAllowed());
        oldHackathon.setStartDate(hackathon.getStartDate());
        oldHackathon.setEndDate(hackathon.getEndDate());
        oldHackathon.setCompanyName(hackathon.getCompanyName());
        oldHackathon.setCity(hackathon.getCity());
        oldHackathon.setIsOnline(hackathon.getIsOnline());
        oldHackathon.setWinningTeamId(hackathon.getWinningTeamId());
        oldHackathon.setIdTeams(hackathon.getIdTeams());

        hackathonRepository.save(oldHackathon);
    }

    public void deleteHackathon(Integer id){
        Hackathon hackathon=hackathonRepository.findHackathonById(id);
        if(hackathon==null){
            throw new ApiException("Hackathon not found");
        }
        hackathonRepository.delete(hackathon);
    }
    public void assignTeamToHackathon(Integer hackathonId,Integer teamId){
        Hackathon hackathon=hackathonRepository.findHackathonById(hackathonId);
        Team team=teamRepository.findTeamById(teamId);
        if(hackathon==null||team==null){
            throw new ApiException("Hackathon or team not found");
        }
        if(hackathon.getMin()>team.getMembers().size()||hackathon.getMax()<team.getMembers().size()){
            throw new ApiException("Minimum Number Of Members Is : "+hackathon.getMin()+" Maximum Number Of Members Is : "+hackathon.getMax());
        }
        team.setHackathon(hackathon);
        List<Integer>t=hackathon.getIdTeams();
        t.add(teamId);
        hackathon.setIdTeams(t);

        Set<Team>s=hackathon.getTeams();
        s.add(team);
        hackathon.setTeams(s);

        hackathonRepository.save(hackathon);
        teamRepository.save(team);
    }

}
