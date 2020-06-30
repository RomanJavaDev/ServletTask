
package com.myproject.servlet;

import com.myproject.dao.LaptopDao;
import com.myproject.pojo.Laptop;
import com.myproject.servlet.AppContextListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@WebServlet(urlPatterns = "/allLaptops", name = "Laptops")
public class AllLaptopsServlet extends HttpServlet {
    private LaptopDao laptopDao;
    private Logger logger = LoggerFactory.getLogger(AppContextListener.class);

    @Override
    public void init() throws ServletException {
        laptopDao = (LaptopDao) getServletContext().getAttribute("dao");
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Collection<Laptop> laptops = laptopDao.getAllLaptop();
        req.setAttribute("laptops", laptops);
        req.setAttribute("PageTitle", "Laptops");
        req.setAttribute("PageBody", "allLaptops.jsp");
        req.getRequestDispatcher("/layout.jsp")
                .forward(req, resp);
    }
}