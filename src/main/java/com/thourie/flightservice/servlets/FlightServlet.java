package com.thourie.flightservice.servlets;

import com.thourie.flightservice.models.Flight;
import com.thourie.flightservice.services.FlightService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.thymeleaf.TemplateEngine;

import java.util.List;

@WebServlet("/flights")
public class FlightServlet extends HttpServlet {

    private final FlightService flightService = FlightService.getInstance();
    private TemplateEngine templateEngine;



    @SneakyThrows
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        // Получаем список перелётов
        List<Flight> flights = flightService.getAll();

        // Передаём данные в JSP
        request.setAttribute("flights", flights);

        // Перенаправляем на JSP-страницу
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/flights.jsp");
        dispatcher.forward(request, response);
    }


}
