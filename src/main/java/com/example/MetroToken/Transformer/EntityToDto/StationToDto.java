package com.example.MetroToken.Transformer.EntityToDto;

import com.example.MetroToken.DTO.Response.StationResponse;
import com.example.MetroToken.Model.Station;

public class StationToDto {
    public static StationResponse stationToDto(Station s){
        return StationResponse.builder()
                .name(s.getStationName())
                .message("Has been added successfully")
                .build();
    }
}
