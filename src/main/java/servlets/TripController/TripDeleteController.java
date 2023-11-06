package servlets.TripController;

import daos.TripDAO.TripDAOCons;
import daos.TripDAO.TripDAOImpl;
import entities.Trip;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "TripDeleteController", urlPatterns = "/trip-delete")
public class TripDeleteController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tripId = req.getParameter("tripId");
        if (tripId != null) {
            try {
                if (new TripDAOImpl().removeTripByTripId(tripId)) {
                    req.setAttribute("message", "Delete " + TripDAOCons.SUCCESS);
                    req.getRequestDispatcher("/trip-list").include(req, resp);
                } else {
                    req.setAttribute("message", "Delete " + TripDAOCons.FAIL);
                    req.getRequestDispatcher("/trip-list").include(req, resp);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                req.setAttribute("message", "Delete " + TripDAOCons.FAIL);
                req.getRequestDispatcher("/trip-list").include(req, resp);
            }
        } else {
            req.setAttribute("message", "Delete " + TripDAOCons.FAIL + " cause there is no param!");
            req.getRequestDispatcher("/trip-list").include(req, resp);
        }
    }
}
