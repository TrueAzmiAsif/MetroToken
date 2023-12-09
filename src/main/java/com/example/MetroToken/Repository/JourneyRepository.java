package com.example.MetroToken.Repository;

import com.example.MetroToken.Model.Journey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JourneyRepository extends JpaRepository<Journey,Integer> {
}
