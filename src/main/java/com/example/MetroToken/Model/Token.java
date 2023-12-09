package com.example.MetroToken.Model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level=AccessLevel.PRIVATE)
@Entity
@Builder
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String uid;
    String boardingStation;
    String destination;
    int price;
    @CreationTimestamp
    Date date;
    @ManyToOne
    @JoinColumn
    Station station;
    @OneToOne(mappedBy = "token",cascade = CascadeType.ALL)
    Journey journey;
}
