import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;
public class printdatabase {
	Connection con=null;
	public static Connection dbConnector()
	{
		try {
			Class.forName("org.sqlite.JDBC");
			Connection con=DriverManager.getConnection("jdbc:sqlite:E:\\Java Project\\ITZoneLogin\\src\\printdb.db");

			return con;
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}


}
