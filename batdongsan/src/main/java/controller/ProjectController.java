package controller;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Project;
import service.ProjectService;
import service.ProjectServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static java.lang.Integer.parseInt;

@WebServlet(urlPatterns = "/ProjectController/*")
public class ProjectController extends HttpServlet {
    private static final long serialVersionUID=1L;
    private ProjectService projectService;

    @Override
    public void init() throws ServletException {
        super.init();
        projectService=new ProjectServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out=resp.getWriter();
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        String pathInfo= req.getPathInfo();// local..../employees/giay/nu
        Gson gson=new Gson();
        if(pathInfo==null){
            List<Project> list=projectService.findAllProject();
            if(list.size()>0){
                String jsonData=gson.toJson(list);
                out.print(jsonData);
            }
            out.close();
        }else {
            String[] parts = pathInfo.substring(1).split("/");
            int id = parseInt(parts[0]);
            if (parts.length == 1) {
                Project project = projectService.findById(id);
                String jsonData = gson.toJson(project);
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
            Project project=gson.fromJson(req.getReader(), Project.class);
            projectService.save(project);
            resp.setStatus(HttpServletResponse.SC_CREATED);
        }else{
            resp.setStatus(HttpServletResponse.SC_EXPECTATION_FAILED);
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
        projectService.deleteById(id);
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
            Project project=gson.fromJson(req.getReader(), Project.class);
            projectService.updatefindById(parseInt(jsonData),project);
        }
    }
}
