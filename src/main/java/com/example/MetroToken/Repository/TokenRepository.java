package com.example.MetroToken.Repository;

import com.example.MetroToken.Model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<Token,Integer> {
    public Token findByUid(String tokenuid);
}
