package com.example.MetroToken.Service;

import com.example.MetroToken.DTO.Response.TokenResponse;
import com.example.MetroToken.Exception.StationDoesNotExistException;

public interface TokenService {
    public TokenResponse buy(String board,String dest) throws StationDoesNotExistException;
}
