package servlets.filters;

import entities.Employee;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebFilter("/*")
public class LogInFilter implements Filter {
    private List<String> excludedRequest;
    private List<String> excludedRequestEmp;
    private List<String> excludedRequestPark;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        excludedRequest = new ArrayList<>();
        excludedRequestEmp = new ArrayList<>();
        excludedRequestPark = new ArrayList<>();
        excludedRequest.add("/login");
        excludedRequest.add(".js");
        excludedRequest.add(".css");
        excludedRequestEmp.add("/add-emp");
        excludedRequestEmp.add("/employeehome");
        excludedRequestEmp.add("/delete-emp");
        excludedRequestEmp.add("/list-emp");
        excludedRequestEmp.add("/view-emp");
        excludedRequestEmp.add("/search-emp");
        excludedRequestEmp.add("/logout");
        excludedRequestPark.add("/parkinghome");
        excludedRequestPark.add("/AddBooking");
        excludedRequestPark.add("/BookingList");
        excludedRequestPark.add("/DeleteBooking");
        excludedRequestPark.add("/SearchBooking");
        excludedRequestPark.add("/UpdateBooking");
        excludedRequestPark.add("/ViewBooking");
        excludedRequestPark.add("/addCar");
        excludedRequestPark.add("/deleteCar");
        excludedRequestPark.add("/updateCar");
        excludedRequestPark.add("/listCar");
        excludedRequestPark.add("/searchCar");
        excludedRequestPark.add("/addParkingLot");
        excludedRequestPark.add("/deleteParkingLot");
        excludedRequestPark.add("/editParkingLot");
        excludedRequestPark.add("/listParkingLot");
        excludedRequestPark.add("/searchParkingLot");
        excludedRequestPark.add("/ticket-add");
        excludedRequestPark.add("/ticket-delete");
        excludedRequestPark.add("/ticket-list");
        excludedRequestPark.add("/ticket-view");
        excludedRequestPark.add("/ticket-search");
        excludedRequestPark.add("/trip-add");
        excludedRequestPark.add("/trip-delete");
        excludedRequestPark.add("/trip-edit");
        excludedRequestPark.add("/trip-list");
        excludedRequestPark.add("/trip-search");
        excludedRequestPark.add("/logout");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
        String userRequest = req.getRequestURI();
        boolean loggedIn = session != null && session.getAttribute("loginEmp") != null;
        String dept = "";
        if (session.getAttribute("loginEmp") != null) {
            Employee employee = (Employee) session.getAttribute("loginEmp");
            dept = employee.getDepartment();
        }
        if (loggedIn || isValidRequest(userRequest, excludedRequest)) {
            if (dept.equals("employee")) {
                if (isValidRequest(userRequest, excludedRequestEmp)) {
                    chain.doFilter(req, resp);
                } else {
                    resp.sendRedirect(req.getContextPath() + "/employeehome");
                }
            } else if (dept.equals("parking")) {
                if (isValidRequest(userRequest, excludedRequestPark)) {
                    chain.doFilter(req, resp);
                } else {
                    resp.sendRedirect(req.getContextPath() + "/parkinghome");
                }
            } else chain.doFilter(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/login");
        }
    }

    private boolean isValidRequest(String request, List<String> excludedRequest) {
        for (String excluded : excludedRequest) {
            if (request.endsWith(excluded)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void destroy() {

    }
}
