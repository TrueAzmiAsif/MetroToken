package com.example.MetroToken.Controller;

import com.example.MetroToken.DTO.Response.JourneyResponse;
import com.example.MetroToken.DTO.Response.TokenResponse;
import com.example.MetroToken.Exception.EntryNotAllowedException;
import com.example.MetroToken.Exception.InvalidTokenException;
import com.example.MetroToken.Exception.StationDoesNotExistException;
import com.example.MetroToken.Exception.TokenExpiredException;
import com.example.MetroToken.Service.Implementation.JourneyServiceImpl;
import com.example.MetroToken.Service.JourneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/journey")
public class JourneyController {
    @Autowired
    JourneyServiceImpl jserv;

    @PostMapping("/entry")
    public ResponseEntity entry(@RequestParam("stationName") String name, @RequestParam("tokenUid") String tokenUid){
        JourneyResponse jresp;
        try {
            jresp=jserv.entry(name,tokenUid);
        }
        catch(InvalidTokenException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        catch(EntryNotAllowedException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        catch(TokenExpiredException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(jresp, HttpStatus.CREATED);
    }
    @PostMapping("/exit")
    public ResponseEntity exit(@RequestParam("stationName") String name, @RequestParam("tokenUid") String tokenUid){
        JourneyResponse jresp;
        try {
            jresp=jserv.exit(name,tokenUid);
        }
        catch (InvalidTokenException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (TokenExpiredException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (EntryNotAllowedException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(jresp, HttpStatus.CREATED);
    }
}
