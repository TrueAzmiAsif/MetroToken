package com.example.MetroToken.Transformer.DtoToEntity;

import com.example.MetroToken.Model.Token;

import java.util.UUID;

public class DtoToToken {
    public static Token dtoToToken(String board, String dest,int fare){
        return Token.builder()
                .boardingStation(board)
                .destination(dest)
                .uid(UUID.randomUUID().toString())
                .price(fare)
                .build();
    }
}
