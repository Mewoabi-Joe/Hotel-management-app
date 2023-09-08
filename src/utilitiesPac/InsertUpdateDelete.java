package utilitiesPac;

import java.sql.Connection;
import java.sql.Statement;

public class InsertUpdateDelete {
    public static void runQuery(String query, String msg){
        Connection con = null;
        Statement st = null;
        try{
            con = ConnectionProvider.getCon();
            st = con.createStatement();
            st.executeUpdate(query);
            if(!msg.equals("")){
                JavaFXDialogs.informationDialog(msg);
            }
        }catch (Exception e){
            JavaFXDialogs.exceptionDialog(e,"error while trying to insert or update into Database");
        }
    }
}
