package projects.service;

import java.sql.SQLException;

import projects.dao.ProjectsDao;
import projects.entity.Project;

public class ProjectService {
	private ProjectsDao projectDao = new ProjectsDao();
	
public Project addProject(Project project) throws SQLException {
  return projectDao.insertProject(project);
	}
}
