package edu.eci.arsw.airportFinder.controllers;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import edu.eci.arsw.airportFinder.httpconnectionservice.HttpConnectionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;


@RestController
@RequestMapping(value = "/airports")
public class AirportFinderController {

    @RequestMapping(method = RequestMethod.GET, path="/{city}")
    public ResponseEntity<?> manejadorGetRecursoBlueprints(@PathVariable("city") String city) {
        try {
            HttpResponse<JsonNode> res = HttpConnectionService.getAirportByName(city);
            return new ResponseEntity<>(res, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(AirportFinderController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
        }
    }
}
