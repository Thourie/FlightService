package com.thourie.flightservice.daos;

import com.thourie.flightservice.models.Flight;
import com.thourie.flightservice.models.FlightStatus;
import com.thourie.flightservice.services.FlightService;
import com.thourie.flightservice.utils.ConnectionManager;
import jakarta.persistence.EntityManager;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FlightDao implements Dao<Flight, Long> {

    private static final FlightDao INSTANCE = new FlightDao();

    private final Connection connection = ConnectionManager.getConnection();

    private final static String FIND_ALL = "select * from flight";

    public static FlightDao getInstance() {
        return INSTANCE;
    }

    @Override
    @SneakyThrows
    public List<Flight> findAll() {
        PreparedStatement ps = connection.prepareStatement(FIND_ALL);
        ResultSet rs = ps.executeQuery();
        List<Flight> flights = new ArrayList<>();
        while (rs.next()) {
            flights.add(Flight.builder()
                    .id(rs.getLong("id"))
                    .flightNo(rs.getString("flight_no"))
                    .departureDate(rs.getObject("departure_date", Timestamp.class).toLocalDateTime())
                    .departureAirportCode(rs.getString("departure_airport_code"))
                    .arrivalDate(rs.getObject("arrival_date", Timestamp.class).toLocalDateTime())
                    .arrivalAirportCode(rs.getString("arrival_airport_code"))
                    .aircraftId(rs.getLong("aircraft_id"))
                    .status(FlightStatus.valueOf(rs.getString("status")))
                    .build());
        }


        return flights;
    }

    @Override
    public Optional<Flight> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long aLong) {
        return false;
    }

    @Override
    public Flight save(Flight flight) {
        return null;
    }

    @Override
    public void update(Flight flight) {

    }
}
