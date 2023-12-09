package com.example.MetroToken.Service;

import com.example.MetroToken.DTO.Request.StationRequest;
import com.example.MetroToken.DTO.Response.StationResponse;

public interface StationService {
    public StationResponse add(StationRequest sreq);
}
