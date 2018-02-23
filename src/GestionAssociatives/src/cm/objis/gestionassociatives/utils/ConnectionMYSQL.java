package cm.objis.gestionassociatives.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMYSQL {
	
	
	//information d'accès à la base de données
		public static String url = "jdbc:mysql://localhost/gestionassociatives";
		public static String login = "root";
		public static String passwd = "rootroot";
		public static Connection connection;
		
		/**
		 * methode de connection 
		 * elle ne prend rien en paramètre
		 * @return une connection 
		 */
		public static Connection getInstance() {
			if (connection == null) {
				
				try {
					connection = DriverManager.getConnection(url, login, passwd);
					System.out.println("connection réussie");
				}catch(SQLException e) {
					System.out.println("problème de connexion");
				}
				
			}
			
			return connection;
			
		}
		

}
