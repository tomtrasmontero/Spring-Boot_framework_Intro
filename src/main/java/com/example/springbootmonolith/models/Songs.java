package com.example.springbootmonolith.models;

import lombok.*;
import javax.persistence.*;

@Data
//automatically creates setters and getters with lombok
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Entity @Table(name = "SONGS")
public class Songs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "LENGTH")
    private String length;

}