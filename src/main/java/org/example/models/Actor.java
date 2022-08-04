package org.example.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Table
@Getter
@Setter
@Entity
public class Actor {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String first_name;

    private String last_name;

    @OneToMany(mappedBy = "actor")
    private List<Character> characters = new ArrayList<>();


}
