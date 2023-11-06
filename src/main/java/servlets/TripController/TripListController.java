package servlets.TripController;

import daos.TripDAO.TripDAOImpl;
import daos.TripDAO.iTripDAO;
import entities.Trip;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "TripListController", urlPatterns = "/trip-list")
public class TripListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        iTripDAO tripDAO = new TripDAOImpl();
        try {
            List<Trip> tripList = tripDAO.getAllTrip();
            int[] years = tripDAO.getMinAndMaxYearFromTrip();
            req.setAttribute("years", years);
            req.setAttribute("tripList", tripList);
            req.getRequestDispatcher("views/TripJSP/TripListJSP.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
