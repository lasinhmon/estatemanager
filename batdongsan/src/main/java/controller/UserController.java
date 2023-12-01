package controller;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
import service.UserService;
import service.UserServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static java.lang.Integer.parseInt;

@WebServlet(urlPatterns = "/UserController/*")
public class UserController extends HttpServlet {
    private static final long serialVersionUID=1L;
    private UserService userService;

    @Override
    public void init() throws ServletException {
        super.init();
        userService=new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out=resp.getWriter();
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        String pathInfo= req.getPathInfo();// local..../employees/giay/nu
        Gson gson=new Gson();
        if(pathInfo==null){
            List<User> list=userService.findAllUser();
            if(list.size()>0){
                String jsonData=gson.toJson(list);
                out.print(jsonData);
            }
            out.close();
        }else {
            String[] parts = pathInfo.substring(1).split("/");
            String us = parts[0];
            if (parts.length == 1) {
                User user = userService.findByUserName(us);
                String jsonData = gson.toJson(user);
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
//        String[] parts = pathInfo.substring(1).split("/");
//        String jsonData=gson.toJson(parts[0]);//1
        String jsonData = req.getPathInfo();
        if(jsonData.equals("/login")){//if else if sel
            User user=gson.fromJson(req.getReader(), User.class);
            User us =userService.check(user);
            PrintWriter out=resp.getWriter();
            if(us!=null){
                Gson gs=new Gson();
                String jsonPass=gs.toJson(us);
                out.print(jsonPass);
                out.close();
            }else{
                resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }

        }
        else if(jsonData.equals("/register")){
            User user=gson.fromJson(req.getReader(), User.class);
            User us =userService.check(user);
            PrintWriter out=resp.getWriter();
            if(us==null){
                userService.save(user);
                Gson gs=new Gson();
                String jsonPass=gs.toJson(us);
                out.print(jsonPass);
                out.close();
            }else{
                resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }
        }
        else if(jsonData.equals("/add")){
            User user=gson.fromJson(req.getReader(), User.class);
            User us =userService.check(user);
            PrintWriter out=resp.getWriter();
            if(us==null){
                userService.addStaff(user);
                Gson gs=new Gson();
                String jsonPass=gs.toJson(us);
                out.print(jsonPass);
                out.close();
            }else{
                resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }
        }
        else{
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
            User user=gson.fromJson(req.getReader(), User.class);
            userService.updatefindByUserName(jsonData,user);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        String pathInfo= req.getPathInfo();
        //  Gson gson=new Gson();
        String parts = pathInfo.substring(1);
        userService.deleteByUserName(parts);
    }
}
