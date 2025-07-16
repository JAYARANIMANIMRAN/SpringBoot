package com.example.SpringBoot.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user_details")



public class RegisterDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empid;

    @Column(name="emp_name")
    private String empName;
    @Column(name="email",nullable = false,unique = true)
    private String email;
    private String password;
    @Column(name = "job")
    private String job;
    //        private String gender ;
    //
    //        @Column(name="date_of_birth")
    //        private Date dob;
    @Column(name="user_name",nullable = false,unique = true)
    private String username;
    @ManyToMany(fetch =FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name ="user_roles",joinColumns = @JoinColumn(name="user_id",referencedColumnName = "empid"),inverseJoinColumns = @JoinColumn(name="roleid",referencedColumnName = "roleID"))
    private Set<Roles> roles;


}


