package edu.eci.arsw.airportFinder.httpconnectionservice;


import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import edu.eci.arsw.airportFinder.cache.AirportFinderCache;

public class HttpConnectionService {

    static Object response;

    public static HttpResponse<JsonNode> getAirportByName(String name) throws UnirestException {
        HttpResponse<JsonNode> jsonResponse
                = Unirest.get("https://cometari-airportsfinder-v1.p.rapidapi.com/api/airports/by-text")
                .header("x-rapidapi-host", "cometari-airportsfinder-v1.p.rapidapi.com")
                .header("x-rapidapi-key", "4c9808cb42msh4449ed2c1fe658dp107e4ejsn237d8c1fe675")
                .queryString("text",name)
                .asJson();
        //AirportFinderCache.add(jsonResponse.getBody().toString());
        return jsonResponse;
    }

    public static Object findAirportByName(String name) throws UnirestException {
        response = getAirportByName(name).getBody().getObject();
        return response;
    }

    public static void main(String[] args) throws UnirestException {
        HttpConnectionService n = new HttpConnectionService();
        System.out.println(n.getAirportByName("berlin").getBody().toString());
    }
}
