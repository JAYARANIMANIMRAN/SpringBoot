package com.example.SpringBoot.model;

import com.example.SpringBoot.service.CustomUserDetailService;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor


public class UserDetailDto {


        private int empid;

        private String name;

        private String email;

        private String password;

        private String userName;

        private Set<String> roleNames;



}
