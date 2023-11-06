package servlets.CarController;

import daos.CarDAO.CarDAO;
import daos.CarDAO.CarDAOimp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/deleteCar")
public class DeleteCarController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    CarDAO carDAO = new CarDAOimp();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String licensePlate = req.getParameter("licensePlate");
        try {
            carDAO.delete(licensePlate);
            resp.sendRedirect(req.getContextPath() + "/listCar");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
