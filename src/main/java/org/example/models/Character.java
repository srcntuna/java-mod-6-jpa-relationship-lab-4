package org.example.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Table
@Getter
@Setter
@Entity
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @ManyToOne
    private Actor actor;

    @ManyToOne
    private Show show;

    private String catchprase;

}
