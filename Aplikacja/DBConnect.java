package projektIO;

import java.sql.*;

public class DBConnect {
	private Connection con;
	private Statement st;
	private ResultSet rs;

	public DBConnect(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://mysql.agh.edu.pl/jakubs1","jakubs1","2n3k7t2NKukesf22");
			st= con.createStatement();
		}catch(Exception ex){
				System.out.println("Erro: "+ex);
		}
	}
	
	public void getData(){
		try{
			String query = "select * from klienci";
			rs =st.executeQuery(query);
			while(rs.next()){
				String name= rs.getString("imie");
				String last_name = rs.getString("nazwisko");
				System.out.println(name+" nazwisko "+last_name);
			}
		}catch(Exception ex){
						System.out.println(ex);
		}	
	}
}
