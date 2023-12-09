package com.example.MetroToken.Service.Implementation;

import com.example.MetroToken.DTO.Response.JourneyResponse;
import com.example.MetroToken.Exception.EntryNotAllowedException;
import com.example.MetroToken.Exception.InvalidTokenException;
import com.example.MetroToken.Exception.TokenExpiredException;
import com.example.MetroToken.Model.Journey;
import com.example.MetroToken.Model.Token;
import com.example.MetroToken.Repository.TokenRepository;
import com.example.MetroToken.Service.JourneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class JourneyServiceImpl implements JourneyService {
    @Autowired
    TokenRepository trep;
    public JourneyResponse entry(String name, String tokenUid) throws InvalidTokenException, EntryNotAllowedException, TokenExpiredException {
        Token t=trep.findByUid(tokenUid);
        Journey journey;
        if(t==null || t.getJourney()!=null){
            throw new InvalidTokenException("Invalid Token");
        }
        else if(!t.getBoardingStation().equalsIgnoreCase(name)){
            throw new EntryNotAllowedException("Please board the metro from correct boarding station");
        }
        else if(((new Date().getTime()-t.getDate().getTime())/(1000*3600))>18){
            throw new TokenExpiredException("Token Expired");
        }
        else {
            journey=Journey.builder()
                    .entryStation(name)
                    .token(t)
                    .build();
        }
        t.setJourney(journey);
        Token saved=trep.save(t);
        return JourneyResponse.builder()
                .message("Enjoy the journey!")
                .station(name)
                .time(saved.getJourney().getEntryTime().toString())
                .build();
    }

    public JourneyResponse exit(String name, String tokenUid) throws InvalidTokenException, EntryNotAllowedException, TokenExpiredException {
        Token t=trep.findByUid(tokenUid);
        Journey journey;
        if(t==null || t.getJourney()==null || t.getJourney().getExitStation()!=null){
            throw new InvalidTokenException("Invalid Token");
        }
        else if(!t.getDestination().equalsIgnoreCase(name)){
            throw new EntryNotAllowedException("Please depart the metro from correct station");
        }
        else if(((new Date().getTime()-t.getDate().getTime())/(1000*3600))>18){
            throw new TokenExpiredException("Token Expired");
        }
        else if(t.getJourney().getEntryStation()==null){
            throw new InvalidTokenException("Invalid Token");
        }
        journey=t.getJourney();
        journey.setExitStation(name);
        journey.setExitTime(new Date());
        Token saved=trep.save(t);
        return JourneyResponse.builder()
                .message("Thank you for travelling with us!")
                .station(name)
                .time(saved.getJourney().getExitTime().toString())
                .build();
    }
}
