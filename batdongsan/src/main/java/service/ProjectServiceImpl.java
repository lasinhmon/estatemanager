package service;


import dao.ProjectDAO;
import dao.ProjectDAOImpl;
import model.Project;

import java.util.ArrayList;
import java.util.List;

public class ProjectServiceImpl implements ProjectService {
    private ProjectDAO projectDAO=new ProjectDAOImpl();
    @Override
    public List<Project> findAllProject() {
        List<Project>list=new ArrayList<>();
        try{
            list=projectDAO.findAllProject();
        }catch(Exception e){
            System.err.println(e);
        }
        return list;
    }

    @Override
    public Project findById(int id) {
        Project project=new Project();
        try{
            project=projectDAO.findById(id);
        }catch (Exception e){
            System.err.println(e);
        }
        return project;
    }
    @Override
    public int save(Project project) {
        int so=-1;
        try{
            so=projectDAO.save(project);
        }catch(Exception e){
            System.err.println(e);
        }
        return so;
    }

    @Override
    public int updatefindById(int i, Project project) {
        int so=-1;
        try{
            so=projectDAO.updatefindById(i,project);
        }catch (Exception e){
            System.err.println(e);
        }
        return so;
    }

    @Override
    public int deleteById(int id) {
        int so=-1;
        try{
            so=projectDAO.deleteById(id);
        }catch (Exception e){
            System.err.println(e);
        }
        return so;
    }
}
