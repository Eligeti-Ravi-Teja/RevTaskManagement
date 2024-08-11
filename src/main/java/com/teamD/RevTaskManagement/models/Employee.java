package com.teamD.RevTaskManagement.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;

    private String employeeName;
    private String email;
    private Date dateOfJoining;
    private String role;
    private String description;
    private String phone;
    private String status;
    private String password;

    @ManyToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<Project> projects;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "employee_skills",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private List<Skill> skills;

    @OneToMany(mappedBy = "sender", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Message> sentMessages;

    @OneToMany(mappedBy = "receiver", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Message> receivedMessages;
}
