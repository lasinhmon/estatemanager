package dao;

import dao.util.ConnectionUtil;
import dao.util.SQLQuery;
import model.Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectDAOImpl implements ProjectDAO {
    @Override
    public List<Project> findAllProject() throws SQLException {
        List<Project> projectList=new ArrayList<>();
        Connection conn= ConnectionUtil.getNewConnection();
        PreparedStatement ps= conn.prepareStatement(SQLQuery.SQL_SELECT_ALL_PROJECT);
        ResultSet rs= ps.executeQuery();
        try{
            while(rs.next()){
                String projectId = rs.getString(1);
                String projectName = rs.getString(2);
                Project project=new Project(projectId,projectName);
                projectList.add(project);
            }
        }catch (SQLException e){
            e.printStackTrace(System.out);
        }finally {
            rs.close();
            ps.close();
            conn.close();
        }
        return projectList;
    }

    @Override
    public Project findById(int id) throws SQLException {
        Project project=new Project();
        Connection conn= ConnectionUtil.getNewConnection();
        PreparedStatement ps= conn.prepareStatement(SQLQuery.SQL_FIND_PROJECT_BY_ID);
        ps.setInt(1, id);
        ResultSet rs=ps.executeQuery();
        try {
            while (rs.next()) {
                String projectId = rs.getString(1);
                String projectName = rs.getString(2);
                project = new Project(projectId, projectName);
                return project;
            }
        }catch (SQLException e){
            e.printStackTrace(System.out);
        }finally {
            rs.close();
            ps.close();
            conn.close();
        }
        return null;
    }
    @Override
    public int save(Project project) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = ConnectionUtil.getNewConnection();
            ps = conn.prepareStatement(SQLQuery.SQL_ADD_PROJECT);
            ps.setString(1, project.getProjectName());
            int row = ps.executeUpdate();
            System.out.println("tao cho thanh cong");
            return row;
        }catch(SQLException e){
            System.out.println("tao cho k thanh cong");
            e.printStackTrace(System.out);
        }finally{
            ps.close();
            conn.close();
        }
        return -1;
    }

    @Override
    public int updatefindById(int i, Project project) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = ConnectionUtil.getNewConnection();
            ps = conn.prepareStatement(SQLQuery.SQL_PROJECT_UPDATE_BY_ID);
            ps.setString(1, project.getProjectName());
            ps.setInt(2, i);
            int row = ps.executeUpdate();
            return row;
        }catch(SQLException e){
            e.printStackTrace(System.out);
        }finally{
            ps.close();
            conn.close();
        }
        return -1;
    }

    @Override
    public int deleteById(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = ConnectionUtil.getNewConnection();
            ps = conn.prepareStatement(SQLQuery.SQL_PROJECT_DELETE_BY_ID);
            ps.setInt(1, id);
            int row = ps.executeUpdate();
            return row;
        }catch(SQLException e){
            e.printStackTrace(System.out);
        }finally{
            ps.close();
            conn.close();
        }
        return -1;
    }
}
