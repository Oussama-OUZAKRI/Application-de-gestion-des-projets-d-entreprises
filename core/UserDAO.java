package core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {
	
	private static String[] session = Session.getutilisateurConnecte();
	
	public static void mettreAJourUtilisateur(String nouveauPrenom, String nouveauNom, 
			String nouveauAdresse, String nouveauTel, String nouveauMail, String nouveauCIN,
			String nouveauCompte, String nouveauID, String nouveauPasswd) {
		
		Connection conn=null;
		String dbname="execusync";
		String url="jdbc:mysql://localhost:3306/"+dbname;
		String userName = "root";
		String password = "123456789";
		
        try {
			conn = DriverManager.getConnection(url, userName, password);
            String updateQuery = "UPDATE appuser SET user_firstName=?, user_lastName=?, user_address=?, "
            		+ "user_phone=?, user_mail=?, user_CIN=?, user_credential=?, "
            		+ "user_login=?, user_password=? WHERE user_id=?";
            try (PreparedStatement preparedStatement = conn.prepareStatement(updateQuery)) {
                preparedStatement.setString(1, nouveauPrenom);
                preparedStatement.setString(2, nouveauNom);
                preparedStatement.setString(3, nouveauAdresse);
                preparedStatement.setString(4, nouveauTel);
                preparedStatement.setString(5, nouveauMail);
                preparedStatement.setString(6, nouveauCIN);
                preparedStatement.setString(7, nouveauCompte);
                preparedStatement.setString(8, nouveauID);
                preparedStatement.setString(9, nouveauPasswd);
                preparedStatement.setString(10, session[10]);
                
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
	}
}
