package org.example.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Table (name = "SHOW")
@Getter
@Setter
@Entity
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private String showDay;

    private String season;

    private String genre;

    @ManyToOne
    private Network network;

    @OneToMany (mappedBy = "show")
    private List<Character> characters = new ArrayList<>();

}
