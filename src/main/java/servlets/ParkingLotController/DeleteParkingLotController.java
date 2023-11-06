package servlets.ParkingLotController;

import daos.ParkingLotDAO.ParkingLotDAOImpl;
import entities.ParkingLot;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/deleteParkingLot")
public class DeleteParkingLotController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ParkingLotDAOImpl lotDAO = new ParkingLotDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            boolean check = lotDAO.deleteParkingLot(id);
            if (check) {
                resp.sendRedirect("listParkingLot");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
