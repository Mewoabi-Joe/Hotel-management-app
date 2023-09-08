package utilitiesPac;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Select {
    public static ResultSet getData(String query) {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            con = ConnectionProvider.getCon();
            st = con.createStatement();
            rs = st.executeQuery(query);
            return rs;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }


    }
}
