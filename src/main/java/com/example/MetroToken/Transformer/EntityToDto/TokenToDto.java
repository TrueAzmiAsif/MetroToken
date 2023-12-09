package com.example.MetroToken.Transformer.EntityToDto;

import com.example.MetroToken.DTO.Response.TokenResponse;
import com.example.MetroToken.Model.Token;

public class TokenToDto {
    public static TokenResponse tokenToDto(Token t){
        return TokenResponse.builder()
                .uid(t.getUid())
                .boardingStation(t.getBoardingStation())
                .destinationStation(t.getDestination())
                .TimeOfBooking(t.getDate().toString())
                .amountPaid(t.getPrice())
                .build();
    }
}
