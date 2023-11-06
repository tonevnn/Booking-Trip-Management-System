package servlets.BookingOfficeController;


import daos.BookingOfficeDAO.BookingDAOimp;
import daos.BookingOfficeDAO.BookingDAOimp;
import entities.BookingOffice;
import entities.ParkingLot;
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

@WebServlet(name = "SearchBooking", urlPatterns = {"/SearchBooking"})
public class SearchBooking extends HttpServlet {
    private BookingDAOimp d = new BookingDAOimp();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try {
            String keyword = request.getParameter("keyword");
            String criteria = request.getParameter("criteria");
            List<BookingOffice> list;
            List<Trip> t = d.getAllDestination();
            request.setAttribute("listT", t);
            if (keyword.equals("")) {
                list = d.getAllBooking();
            } else {
                list = d.searchBooking(keyword, criteria);
            }
            request.setAttribute("listB", list);
            request.setAttribute("keyword", keyword);
            request.setAttribute("criteria", criteria);
            request.getRequestDispatcher("views/BookingOfficeJSP/BookingList.jsp").forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}