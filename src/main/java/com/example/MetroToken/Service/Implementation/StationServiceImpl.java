package com.example.MetroToken.Service.Implementation;

import com.example.MetroToken.DTO.Request.StationRequest;
import com.example.MetroToken.DTO.Response.StationResponse;
import com.example.MetroToken.Model.Station;
import com.example.MetroToken.Repository.StationRepository;
import com.example.MetroToken.Service.StationService;
import com.example.MetroToken.Transformer.DtoToEntity.DtoToStation;
import com.example.MetroToken.Transformer.EntityToDto.StationToDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StationServiceImpl implements StationService {
    @Autowired
    StationRepository srep;
    public StationResponse add(StationRequest sreq){
        Station s= DtoToStation.dtoToStation(sreq);
        Station saved=srep.save(s);
        return StationToDto.stationToDto(saved);
    }
}
