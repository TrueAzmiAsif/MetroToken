package com.example.MetroToken.Controller;

import com.example.MetroToken.DTO.Request.StationRequest;
import com.example.MetroToken.DTO.Response.TokenResponse;
import com.example.MetroToken.Service.Implementation.StationServiceImpl;
import com.example.MetroToken.Service.StationService;
import com.example.MetroToken.Service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Station")
public class StationController {
    @Autowired
    StationService sserv;
    @PostMapping("/add")
    public ResponseEntity buy(@RequestBody StationRequest s){
        return new ResponseEntity(sserv.add(s), HttpStatus.CREATED);
    }
}
