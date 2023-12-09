package com.example.MetroToken.Service.Implementation;

import com.example.MetroToken.DTO.Response.TokenResponse;
import com.example.MetroToken.Exception.EntryNotAllowedException;
import com.example.MetroToken.Exception.InvalidTokenException;
import com.example.MetroToken.Exception.StationDoesNotExistException;
import com.example.MetroToken.Exception.TokenExpiredException;
import com.example.MetroToken.Model.Station;
import com.example.MetroToken.Model.Token;
import com.example.MetroToken.Repository.StationRepository;
import com.example.MetroToken.Repository.TokenRepository;
import com.example.MetroToken.Service.TokenService;
import com.example.MetroToken.Transformer.DtoToEntity.DtoToToken;
import com.example.MetroToken.Transformer.EntityToDto.TokenToDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenServiceImpl implements TokenService {
    @Autowired
    TokenRepository trep;
    @Autowired
    StationRepository srep;
    public TokenResponse buy(String board,String dest) throws StationDoesNotExistException {
        Station boarding=srep.findByStationName(board);
        Station destination=srep.findByStationName(dest);
        if(boarding==null || destination==null){
            throw new StationDoesNotExistException("Metro doesn't cover this station");
        }
        int numberOfStations= destination.getStationNumber()-boarding.getStationNumber();
        int fare=0;
        if(numberOfStations==1)fare=15;
        else if(numberOfStations>1 && numberOfStations<=5)fare=25;
        else fare=60;
        Token t= DtoToToken.dtoToToken(boarding.getStationName(),destination.getStationName(),fare);
        t.setStation(boarding);
        boarding.getTokens().add(t);
        Station saved=srep.save(boarding);
        return TokenToDto.tokenToDto(saved.getTokens().get(saved.getTokens().size()-1));
    }

}
