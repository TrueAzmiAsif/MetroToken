package com.example.MetroToken.Model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@Builder
@Entity
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String stationName;
    int stationNumber;
    @OneToMany(mappedBy = "station",cascade = CascadeType.ALL)
    List<Token> tokens=new ArrayList<>();
}
