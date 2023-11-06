package servlets.TripController;

import daos.TripDAO.TripDAOImpl;
import daos.TripDAO.iTripDAO;
import entities.Trip;
import utils.DateUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

@WebServlet(name = "TripAddController", urlPatterns = "/trip-add")
public class TripAddController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("views/TripJSP/TripAddJSP.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String txtDestination = req.getParameter("txtDestination");
        String txtDepartureTime = req.getParameter("txtDepartureTime");
        String txtDriver = req.getParameter("txtDriver");
        String txtCarType = req.getParameter("txtCarType");
        String txtMaximumTickerNumber = req.getParameter("txtMaximumTickerNumber");
        String txtDepartureDate = req.getParameter("txtDepartureDate");
        try {
            Trip trip = Trip.builder()
                    .destination(txtDestination)
                    .departureTime(DateUtils.convertStringToTime(txtDepartureTime))
                    .driver(txtDriver)
                    .carType(txtCarType)
                    .maximumOnlineTicketNumber(Integer.parseInt(txtMaximumTickerNumber))
                    .departureDate(DateUtils.convertStringToDate(txtDepartureDate))
                    .build();
            iTripDAO tripDAO = new TripDAOImpl();
            String message = "";
            if (tripDAO.insertTrip(trip)) {
                message = "success!";
                req.setAttribute("message", message);
                req.getRequestDispatcher("views/TripJSP/TripAddJSP.jsp").forward(req, resp);
            } else {
                message = "failed!";
                req.setAttribute("message", message);
                req.getRequestDispatcher("views/TripJSP/TripAddJSP.jsp").forward(req, resp);
            }
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
            String message = "Database connection error";
            req.setAttribute("message", message);
            req.getRequestDispatcher("views/TripJSP/TripAddJSP.jsp").forward(req, resp);
        }
    }
}
