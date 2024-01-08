package core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LoginJDBC {
	
	public LoginJDBC() {}
	
	public ArrayList<String[]> verifyUser() {
		Connection conn=null;
		String dbname="execusync";
		String url="jdbc:mysql://localhost:3306/"+dbname;
		String userName = "root";
		String password = "123456789";
		ArrayList<String[]> list = new ArrayList<>();
		try {
			conn = DriverManager.getConnection(url, userName, password);
			if (conn==null) {
				System.out.println("Connection can't be established");
			}
			System.out.println("Connected to '"+dbname+"' database");
			Statement st = conn.createStatement();
			String requete = "SELECT * FROM appuser";
			ResultSet resultat = st.executeQuery(requete);
			String[] tab = new String[10];
			while (resultat.next()) {
				tab[0] = resultat.getString("user_firstName");
				tab[1] = resultat.getString("user_lastName");
				tab[2] = resultat.getString("user_address");
				tab[3] = resultat.getString("user_phone");
				tab[4] = resultat.getString("user_mail");
				tab[5] = resultat.getString("user_CIN");
				tab[6] = resultat.getString("user_credential");
				tab[7] = resultat.getString("user_login");
				tab[8] = resultat.getString("user_password");
				if (resultat.getInt("user_isManager")==1) tab[9]="isManager";
				if (resultat.getInt("user_isIntervenant")==1) tab[9]="isIntervenant";
				list.add(tab);
			}
			conn.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public static void main(String[] args) {
		LoginJDBC login = new LoginJDBC();
		ArrayList<String[]> list = login.verifyUser();
		for (int i=0; i<list.size(); i++) {
			for (String itr : list.get(i)) {
				System.out.print(itr+" ");
			}
			System.out.println();
		}
	}
}
