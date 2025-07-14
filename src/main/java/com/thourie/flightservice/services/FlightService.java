package com.thourie.flightservice.services;

import com.thourie.flightservice.daos.FlightDao;
import com.thourie.flightservice.models.Flight;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FlightService {

    private static FlightService INSTANCE = new FlightService();

    private final FlightDao  flightService = FlightDao.getInstance();

    public static FlightService getInstance() {
        return INSTANCE;
    }

    public List<Flight> getAll(){
        return flightService.findAll();
    }
}
