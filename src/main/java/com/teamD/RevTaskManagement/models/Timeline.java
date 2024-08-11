package com.teamD.RevTaskManagement.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Timeline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int timelineId;

    private String milestone;
    private Date timestamp;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;
}