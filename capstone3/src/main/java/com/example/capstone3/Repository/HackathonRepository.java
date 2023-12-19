package com.example.capstone3.Repository;

import com.example.capstone3.Model.Hackathon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface HackathonRepository extends JpaRepository<Hackathon,Integer> {
    Hackathon findHackathonById(Integer id);

//    @Query("select h from Hackathon h where h.startDate<=?1 and h.endDate>?1")
//    Boolean hackathonDate(LocalDate date);
}
