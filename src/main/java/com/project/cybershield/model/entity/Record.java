package com.project.cybershield.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "records")
public class Record {

    @Id
    @GeneratedValue
    private Long Id;

    private String password;
    private String link;
    private String name;
    private String userIdentifier;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;
}
