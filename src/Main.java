import db.DB;
import db.DBIntegrityException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Connection connection = null;
        PreparedStatement st = null;

        try {
            connection = DB.getConnection();
            st = connection.prepareStatement(
                    "DELETE FROM department"
                    + "WHERE "
                    + "Id = ?");

            st.setInt(1, 5);

            int rowsAffected = st.executeUpdate();

            System.out.println("Rows Affected " + rowsAffected);



        } catch(SQLException e) {
            throw new DBIntegrityException(e.getMessage());
        } finally {
            DB.closeConnection();
            DB.closeStatement(st);
        }
    }
}