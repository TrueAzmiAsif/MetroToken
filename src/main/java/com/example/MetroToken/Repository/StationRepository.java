package com.example.MetroToken.Repository;

import com.example.MetroToken.Model.Station;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepository extends JpaRepository<Station,Integer> {
    public Station findByStationName(String name);
}
