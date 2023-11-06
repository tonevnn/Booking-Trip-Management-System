package servlets.TicketController;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import daos.CarDAO.CarDAO;
import daos.CarDAO.CarDAOimp;
import daos.TicketDAO.TicketDAOCons;
import daos.TicketDAO.TicketDAOImpl;
import daos.TicketDAO.iTicketDAO;
import daos.TripDAO.TripDAOImpl;
import daos.TripDAO.iTripDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "TicketDeleteController", urlPatterns = "/ticket-delete")
public class TicketDeleteController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ticketId = req.getParameter("ticketId");
        iTicketDAO ticketDAO = new TicketDAOImpl();
        iTripDAO tripDAO = new TripDAOImpl();
        CarDAO carDAO = new CarDAOimp();
        if (ticketId == null || ticketId.trim().length() == 0) {
            req.setAttribute("message", TicketDAOCons.FAIL);
        } else {
            try {
                String tripId = ticketDAO.getTripIdByTicketId(ticketId);
                if (ticketDAO.removeTicketByTicketId(ticketId)) {
                    if (tripDAO.updateBookedTicketByTripId(tripId, -1)) {
                        req.setAttribute("message", TicketDAOCons.SUCCESS);
                    } else {
                        req.setAttribute("message", TicketDAOCons.FAIL);
                    }
                } else {
                    req.setAttribute("message", TicketDAOCons.FAIL);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                //ERROR
                req.setAttribute("message", TicketDAOCons.FAIL);
            }
        }
        req.getRequestDispatcher("/ticket-list").include(req, resp);
    }
}
