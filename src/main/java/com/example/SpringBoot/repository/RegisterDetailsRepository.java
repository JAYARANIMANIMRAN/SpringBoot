package com.example.SpringBoot.repository;

import com.example.SpringBoot.model.RegisterDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface RegisterDetailsRepository extends JpaRepository<RegisterDetails,Integer> {


    RegisterDetails findByEmail(String email);

    List<RegisterDetails> findByJob(String job);

    Optional<RegisterDetails> findByUsername(String username);

}
