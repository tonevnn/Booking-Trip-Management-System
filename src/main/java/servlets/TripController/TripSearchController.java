package servlets.TripController;

import daos.TicketDAO.TicketDAOImpl;
import daos.TicketDAO.iTicketDAO;
import daos.TripDAO.TripDAOImpl;
import daos.TripDAO.iTripDAO;
import entities.Ticket;
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
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "TripSearchController", urlPatterns = "/trip-search")
public class TripSearchController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String txtSearch = req.getParameter("txtSearch");
        String day = req.getParameter("day");
        String month = req.getParameter("month");
        String year = req.getParameter("year");
        iTripDAO tripDAO = new TripDAOImpl();
        List<Trip> tripList = null;

        try {
            //if user not input text search => list all
            if (DateUtils.isDateValid(day + "/" + month + "/" + year)) {
                if (txtSearch == null || txtSearch.trim().length() == 0) {
                    tripList = tripDAO.getTripsByDepartureDate(Integer.parseInt(day), Integer.parseInt(month), Integer.parseInt(year));
                } else if (txtSearch != null && txtSearch.trim().length() > 0) {
                    tripList = tripDAO.getTripsByTextSearch(txtSearch, Integer.parseInt(day), Integer.parseInt(month), Integer.parseInt(year));
                }
            } else {
                req.setAttribute("message", "Date invalid!");
                tripList = tripDAO.getAllTrip();
            }
            int[] years = tripDAO.getMinAndMaxYearFromTrip();
            req.setAttribute("day", day);
            req.setAttribute("month", month);
            req.setAttribute("year", year);
            req.setAttribute("years", years);
            req.setAttribute("txtSearch", txtSearch);
            req.setAttribute("tripList", tripList);
            req.getRequestDispatcher("views/TripJSP/TripListJSP.jsp").forward(req, resp);
        } catch (SQLException e) {
            //ERROR
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
