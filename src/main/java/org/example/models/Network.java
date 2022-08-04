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
public class Network {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String call_letters;

    private int channel;

    @OneToMany (mappedBy = "network")
    private List<Show> shows = new ArrayList<>();
}
