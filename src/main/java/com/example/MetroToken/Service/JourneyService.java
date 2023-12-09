package com.example.MetroToken.Service;

import com.example.MetroToken.DTO.Response.JourneyResponse;
import com.example.MetroToken.Exception.EntryNotAllowedException;
import com.example.MetroToken.Exception.InvalidTokenException;
import com.example.MetroToken.Exception.TokenExpiredException;
import org.springframework.stereotype.Service;

@Service
public interface JourneyService {
    public JourneyResponse entry(String name, String tokenUid)throws InvalidTokenException, EntryNotAllowedException, TokenExpiredException;
    //public JourneyResponse exit(String name, String tokenUid)throws InvalidTokenException, EntryNotAllowedException, TokenExpiredException;
}
