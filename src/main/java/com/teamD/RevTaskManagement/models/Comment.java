package com.teamD.RevTaskManagement.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentId;

    private String comment;
    private Date timestamp;
    private String type;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee user;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;
}
