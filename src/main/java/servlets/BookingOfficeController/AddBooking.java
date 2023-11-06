package servlets.BookingOfficeController;

import daos.BookingOfficeDAO.BookingDAOimp;
import entities.BookingOffice;
import entities.Trip;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AddBooking", urlPatterns = {"/AddBooking"})
public class AddBooking extends HttpServlet {

    private BookingDAOimp d = new BookingDAOimp();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        List<BookingOffice> b = d.getAllPlace();
        request.setAttribute("listB", b);
        List<Trip> c = d.getAllDestination();
        request.setAttribute("listC", c);
        request.setAttribute("NOTI", "Add Successfully");
        request.getRequestDispatcher("/views/BookingOfficeJSP/AddBooking.jsp").forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        int tripId = Integer.parseInt(request.getParameter("trip"));
        String phone = request.getParameter("phone");
        String place = request.getParameter("place");
        Double price = Double.parseDouble(request.getParameter("price"));
        Date from = Date.valueOf(request.getParameter("dateFrom"));
        Date to = Date.valueOf(request.getParameter("dateTo"));
        d.addBooking(to, name, phone, place, price, from, tripId);
        try {
            processRequest(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}