package com.myproject.servlet;

import com.myproject.dao.LaptopDao;
import com.myproject.pojo.Laptop;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/showlaptop")
public class ShowLaptopServlet extends HttpServlet {

    private LaptopDao laptopDao;

    @Override
    public void init() throws ServletException {
        laptopDao = (LaptopDao) getServletContext().getAttribute("dao");
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String laptopId = req.getParameter("id");
        if (laptopId == null) {
            throw new ServletException("Missing parameter id");
        }
        Laptop laptop = laptopDao.getLaptopById(Integer.valueOf(laptopId));
        if (laptop == null) {
            resp.setStatus(404);
            req.setAttribute("PageTitle", "Laptops");
            req.setAttribute("PageBody", "notfound.jsp");
            req.getRequestDispatcher("/layout.jsp")
                    .forward(req, resp);
            return;
        }
        req.setAttribute("laptop", laptop);
        req.setAttribute("PageTitle", "Laptops");
        req.setAttribute("PageBody", "showlaptop.jsp");
        req.getRequestDispatcher("/layout.jsp")
                .forward(req, resp);
    }
}