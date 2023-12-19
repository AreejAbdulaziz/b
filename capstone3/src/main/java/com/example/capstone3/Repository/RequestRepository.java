package com.example.capstone3.Repository;

import com.example.capstone3.Model.Member;
import com.example.capstone3.Model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends JpaRepository<Request,Integer> {
    Request findRequestById(Integer id);

    Request findRequestByMember(Member member);
}
