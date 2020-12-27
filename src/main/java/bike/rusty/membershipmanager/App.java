package bike.rusty.membershipmanager;

import bike.rusty.membershipmanager.db.dao.BaseDAO;

import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        try {
            BaseDAO baseDAO = new BaseDAO();
        } catch (SQLException e) {
            System.err.printf("Error opening database:%s", e.getMessage());
        }
    }
}
