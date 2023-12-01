package dao;

import model.Project;

import java.sql.SQLException;
import java.util.List;

public interface ProjectDAO {
    public List<Project> findAllProject()throws SQLException;

    public Project findById(int id)throws SQLException;

    public int save(Project project) throws SQLException;

    public int updatefindById(int i, Project project) throws SQLException;

    public int deleteById(int id) throws SQLException;
}
