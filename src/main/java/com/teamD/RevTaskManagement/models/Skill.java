package com.teamD.RevTaskManagement.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int skillId;

    private String skill;
    private String description;

    @ManyToMany(mappedBy = "skills", cascade = CascadeType.ALL)
    private List<Employee> employees;
}