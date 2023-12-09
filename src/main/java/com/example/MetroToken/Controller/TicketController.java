package com.example.MetroToken.Controller;

import com.example.MetroToken.DTO.Response.TokenResponse;
import com.example.MetroToken.Exception.StationDoesNotExistException;
import com.example.MetroToken.Service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Token")
public class TicketController {
    @Autowired
    TokenService tserv;
    @PostMapping("/buy")
    public ResponseEntity buy(@RequestParam("Boarding Station") String board, @RequestParam("Destination Station") String dest){
        TokenResponse tresp;
        try {
            tresp=tserv.buy(board,dest);
        }
        catch(StationDoesNotExistException e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(tresp, HttpStatus.CREATED);
    }

}
