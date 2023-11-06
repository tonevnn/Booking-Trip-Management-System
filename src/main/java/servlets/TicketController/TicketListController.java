package servlets.TicketController;

import daos.TicketDAO.TicketDAOImpl;
import daos.TicketDAO.iTicketDAO;
import daos.TripDAO.TripDAOImpl;
import daos.TripDAO.iTripDAO;
import entities.Ticket;
import entities.Trip;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "TicketListController", urlPatterns = "/ticket-list")
public class TicketListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        iTicketDAO ticketDAO = new TicketDAOImpl();
        iTripDAO tripDAO = new TripDAOImpl();
        try {
            List<Ticket> ticketList = ticketDAO.getAllTicket();
            List<Trip> tripList = tripDAO.getAllTrip();
            int[] years = tripDAO.getMinAndMaxYearFromTrip();
            req.setAttribute("years", years);
            req.setAttribute("ticketList", ticketList);
            req.setAttribute("tripList", tripList);
            req.getRequestDispatcher("views/TicketJSP/TicketListJSP.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
