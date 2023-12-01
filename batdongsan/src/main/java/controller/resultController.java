package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ContractService;
import service.EstateService;

import java.io.IOException;

@WebServlet(urlPatterns = "/ResultController/*")
public class resultController extends HttpServlet {
    private static final long serialVersionUID=1L;

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatch = req.getRequestDispatcher("/vnpay_return.jsp");
        dispatch.forward(req, resp);
    }
}
