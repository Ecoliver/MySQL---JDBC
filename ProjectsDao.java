package projects.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import provided.util.DaoBase;
import projects.entity.Project;
import projects.exception.DbException;

@SuppressWarnings("unused")
public class ProjectsDao extends DaoBase{
	private static final String CATEGORY_TABLE = "category";
	private static final String MATERIAL_TABLE = "material";
	private static final String PROJECT_TABLE = "project";
	private static final String PROJECT_CATEGORY_TABLE = "project_category";
	private static final String STEP_TABLE = "step";
	private Connection conn;


public Project insertProject(Project project) throws SQLException {
	//@formatter: off
	String sql =""
			+ "INSERT INTO" + PROJECT_TABLE + " "
			+ "(project_name, estimated_hours, actual_hours, difficulty, notes)"
			+ "VALUES "
			+ "(?, ?, ?, ?, ?)";
	//@formatter: on

try (Connection conn = DbConnection.getConnection()) {		
	startTransaction(conn);}
return project;
}
public static void setParameter(PreparedStatement stmt, int index, Object value) throws SQLException {
    stmt.setObject(index, value);
}



public static void main(String[] args) {
    Connection conn = null; // Initialize with proper connection object
    String sql = ""; // Initialize with your SQL query

    try (@SuppressWarnings("null")
	PreparedStatement stmt1 = conn.prepareStatement(sql)) {
        Project project = new Project(); // Assuming Project is a class and you have an instance
        setParameter(stmt1, 1, project.getProjectName());
        setParameter(stmt1, 2, project.getEstimatedHours());
        setParameter(stmt1, 3, project.getActualHours());
        setParameter(stmt1, 4, project.getDifficulty());
        setParameter(stmt1, 5, project.getNotes());

        stmt1.executeUpdate(); // Moved inside the try-with-resources block
    } catch (SQLException e) {
        e.printStackTrace(); // Handle SQLException appropriately
    } finally {
        // Close resources if needed
    }
}
	
	
private int getLastInsertId(Connection conn) throws SQLException {
    try (PreparedStatement stmt = conn.prepareStatement("SELECT LAST_INSERT_ID()")) {
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                throw new SQLException("No last insert ID obtained.");
            }
            } finally {
            }
        }
    }
private void startTransaction(Connection conn) {
	// TODO Auto-generated method stub
	
}


private void rollbackTransaction(Connection conn) {
	// TODO Auto-generated method stub
	
}


private void commitTransaction(Connection conn) {
	// TODO Auto-generated method stub
	
}


private Integer getLastInsertId(Connection conn, String projectTable) {
	// TODO Auto-generated method stub
	return null;
}
}