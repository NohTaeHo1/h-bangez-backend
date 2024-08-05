package com.bangez.user.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@ToString(exclude = "id")
@Entity(name = "Broker")
public class Broker {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brokerName;
    private Long phone;
    private Long brokerageNum;
    private Long businessNum;
    private String companyName;

//    @OneToMany(mappedBy = "writer", cascade = CascadeType.REMOVE)
//    private List<Article> article;
}
