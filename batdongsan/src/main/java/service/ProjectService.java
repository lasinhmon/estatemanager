package service;

import model.Project;

import java.util.List;

public interface ProjectService {
    public List<Project> findAllProject();

    public Project findById(int id);

    public int save(Project project);

    public int updatefindById(int i, Project project);

    public int deleteById(int id);
}
