package com.webbilly.dao.jdbc;

import com.webbilly.dao.IGenericDAO;
import com.webbilly.domain.SQLiData;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;


/**
 * Created by christopher on 11/22/14.
 */
public class SQLiDAO implements IGenericDAO<SQLiData> {
    private DataSource dataSource;

    //    public void connectToAndQueryDatabase(String username, String password) {
//        try {
//            Connection con = DriverManager.getConnection(
//                    "jdbc:myDriver:myDatabase",
//                    username,
//                    password);
//
//            Statement stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT a, b, c FROM Table1");
//
//            while (rs.next()) {
//                int x = rs.getInt("a");
//                String s = rs.getString("b");
//                float f = rs.getFloat("c");
//            }
//        } catch (Exception e) {
//                //
//        }
//    }
    public void delete(int id) {
        throw new UnsupportedOperationException();
    }

    public SQLiData getById(int id) {
        throw new UnsupportedOperationException();
    }

    public Collection<SQLiData> getAll() {
        throw new UnsupportedOperationException();
    }

    public void save(SQLiData data) {
        Connection con = null;
        Statement stmt = null;
        try {
            con = dataSource.getConnection();
            stmt = con.createStatement();

            String sql = "INSERT INTO sqli (value) VALUE('" + data.getValue() + "')";
            System.out.println(sql);
            stmt.execute(sql);
        } catch (SQLException sqlEx) {
            throw new RuntimeException(sqlEx);
        } finally {
            try {
                if (con != null) con.close();
                if (stmt != null) stmt.close();
            } catch (Exception ex) {


                //do stuff
                throw new RuntimeException(ex);
            }
        }

    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
