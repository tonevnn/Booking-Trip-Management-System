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

@WebServlet(name = "TicketViewController", urlPatterns = "/ticket-view")
public class TicketViewController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ticketId = req.getParameter("ticketId");
        if (ticketId == null || ticketId.trim().length() == 0) {
            //ERROR
        } else {
            iTicketDAO ticketDAO = new TicketDAOImpl();
            iTripDAO tripDAO = new TripDAOImpl();
            try {
                String destination = tripDAO.getDestinationByTripId(ticketId);
                Ticket ticket = ticketDAO.getTicketByTicketId(ticketId);
                req.setAttribute("destination", destination);
                req.setAttribute("ticket", ticket);
                req.getRequestDispatcher("views/TicketJSP/TicketViewJSP.jsp").forward(req, resp);
            } catch (SQLException e) {
                e.printStackTrace();
                //ERROR
            }
        }
    }
}
