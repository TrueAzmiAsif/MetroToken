package com.example.MetroToken.Model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@Entity
@Builder
public class Journey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String entryStation=null;
    @CreationTimestamp
    Date entryTime;
    String exitStation=null;
    Date exitTime;
    @OneToOne
    @JoinColumn
    Token token;
}
