package model.dao.impl;

import model.dao.DepartmentDao;
import model.entities.Department;
import model.exceptions.DB;
import model.exceptions.DbException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DepartmentDaoJDBC implements DepartmentDao {

    private Connection conn;

    public DepartmentDaoJDBC(Connection conn){
        this.conn = conn;
    }

    @Override
    public void deleteById(Department deleted, Department migration) {
        PreparedStatement st = null;
        try{
            conn.setAutoCommit(false);

            if(deleted.getId().equals(migration.getId())){
                throw new DbException("The migration cannot be the same department that will be deleted!");
            }

            st = conn.prepareStatement(
                    "UPDATE seller "
                            + "SET DepartmentId = ? "
                            + "WHERE DepartmentId = ?");

            st.setInt(1, migration.getId());
            st.setInt(2, deleted.getId());

            st.executeUpdate();

            st = conn.prepareStatement(
                    "DELETE FROM department WHERE Id = ?");
            st.setInt(1, deleted.getId());

            st.executeUpdate();

            conn.commit();
        }
        catch (SQLException e){
            try{
                conn.rollback();
                throw new DbException("Transaction rolled back! Caused by: " + e.getMessage());
            }
            catch (SQLException e1){
                throw new DbException("Error trying to rollback! Caused by: " + e1.getMessage());
            }
        }
        finally{
            DB.closeStatement(st);
        }
    }

    @Override
    public void insert(Department obj) {
        
    }

    @Override
    public void update(Department obj) {

    }

    @Override
    public Department findById(Integer id) {
        return null;
    }

    @Override
    public List<Department> findAll() {
        return List.of();
    }
}
