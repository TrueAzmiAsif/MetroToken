package com.example.MetroToken.Transformer.DtoToEntity;

import com.example.MetroToken.DTO.Request.StationRequest;
import com.example.MetroToken.Model.Station;

public class DtoToStation {
    public static Station dtoToStation(StationRequest sreq){
        return Station.builder()
                .stationName(sreq.getStationName())
                .stationNumber(sreq.getStationNumber())
                .build();
    }
}
