package controller;


import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Category;
import service.CategoryService;
import service.CategoryServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/CategoryController/*")
public class CategoryController extends HttpServlet {
    private static final long serialVersionUID=1L;
    private CategoryService categoryService;

    @Override
    public void init() throws ServletException {
        super.init();
        categoryService=new CategoryServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out=resp.getWriter();
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        String pathInfo= req.getPathInfo();// local..../employees/giay/nu
        Gson gson=new Gson();
        if(pathInfo==null){
            List<Category> list=categoryService.findAllCategory();
            if(list.size()>0){
                String jsonData=gson.toJson(list);
                out.print(jsonData);
            }
            out.close();
        }
    }
}
