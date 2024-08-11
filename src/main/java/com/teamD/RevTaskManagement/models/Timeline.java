package com.teamD.RevTaskManagement.models;

import com.teamD.RevTaskManagement.enums.Milestone;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Timeline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int timelineId;

    @Enumerated(EnumType.STRING)
    private Milestone milestone;

    private Date timestamp;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;
}