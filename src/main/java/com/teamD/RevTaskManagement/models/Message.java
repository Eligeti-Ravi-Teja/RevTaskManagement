package com.teamD.RevTaskManagement.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int messageId;

    private String subject;
    private String context;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private Employee sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private Employee receiver;
}