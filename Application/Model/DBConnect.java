package Application.Model;

import java.sql.*;

public class DBConnect
{
	protected Connection con;
	protected Statement st;
	protected ResultSet rs;

	public DBConnect()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://mysql.agh.edu.pl/jakubs1","jakubs1","2n3k7t2NKukesf22");
			st = con.createStatement();
		}
		catch(Exception ex)
		{
			System.out.println("Error: "+ex);
		}
	}

	public ResultSet getData(String query)
	{
		try
		{
			rs = st.executeQuery(query);
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		return rs;
	}
}