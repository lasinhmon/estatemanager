package controller;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Estate;
import service.EstateService;
import service.EstateServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static java.lang.Integer.parseInt;

@WebServlet(urlPatterns = "/EstateController/*")
public class EstateController extends HttpServlet {
    private static final long serialVersionUID=1L;
    private EstateService estateService;

    @Override
    public void init() throws ServletException {
        super.init();
        estateService=new EstateServiceImpl();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out=resp.getWriter();
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        String pathInfo= req.getPathInfo();// local..../employees/giay/nu
        Gson gson=new Gson();
        if(pathInfo==null){
            List<Estate> list=estateService.findAllEstate();
            if(list.size()>0){
                String jsonData=gson.toJson(list);
                out.print(jsonData);
            }
            out.close();
        } else {
            String[] parts = pathInfo.substring(1).split("/");
            int id=parseInt(parts[0]);
            if(parts.length==1){
                Estate estate=estateService.findById(id);
                String jsonData=gson.toJson(estate);
                out.print(jsonData);
                out.close();
            }else {
                String cid=parts[1];
                String price=parts[2];
                List<Estate> list=estateService.findByPidCid(id,cid,price);
                String jsonData=gson.toJson(list);
                out.print(jsonData);
                out.close();
            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        String pathInfo= req.getPathInfo();
        Gson gson=new Gson();
        if(pathInfo==null||pathInfo.equals("/")){//if else if sel
            Estate estate=gson.fromJson(req.getReader(), Estate.class);
            estateService.save(estate);
            resp.setStatus(HttpServletResponse.SC_CREATED);
        }else{
            resp.setStatus(HttpServletResponse.SC_EXPECTATION_FAILED);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out=resp.getWriter();
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json"); //
        String pathInfo= req.getPathInfo();// local..../employees/12
        Gson gson=new Gson();
        if(pathInfo!=null){
            String jsonData = pathInfo.substring(1);
            // int id=parseInt(jsonData);
            Estate estate=gson.fromJson(req.getReader(), Estate.class);
            estateService.updatefindById(parseInt(jsonData),estate);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        String pathInfo= req.getPathInfo();
      //  Gson gson=new Gson();
        String parts = pathInfo.substring(1);
        int id=parseInt(parts);
        estateService.deleteById(id);
    }
}
