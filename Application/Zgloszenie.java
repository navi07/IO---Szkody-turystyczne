package Application;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class Zgloszenie extends DBConnect
{
    private String opis;
    private boolean status;
    protected LocalDate data = LocalDate.of(2015, 01, 10);
    protected double oplata;
    private static int count;
    private int id_polisy;
    int id;

    public Zgloszenie() {};

    void utworz() throws SQLException
    {
        status = false;
        count++;
        id = count;
        Scanner odczyt = new Scanner(System.in);
        System.out.println("Zglaszanie szkody turystycznej\n Podaj potrzebne dane ponizej :");
        System.out.println("Opis : ");
        opis = odczyt.nextLine();
        System.out.println("Oplata : ");
        oplata = odczyt.nextDouble();
        System.out.println("ID polisy : ");
        id_polisy = odczyt.nextInt();

        System.out.println("Dzien : ");
        int d_z = odczyt.nextInt();
        System.out.println("Miesiac : ");
        int m_z = odczyt.nextInt();
        System.out.println("Rok : ");
        int r_z = odczyt.nextInt();
        data = LocalDate.of(r_z, m_z, d_z);
        java.sql.Date data_sql = java.sql.Date.valueOf( data );

        PreparedStatement prepStmt = con.prepareStatement(
                "insert into zgloszenie_szkody_turystycznej values(NULL,?,?,?,?,?);");

        prepStmt.setDate(1, data_sql);
        prepStmt.setString(2, opis);
        prepStmt.setInt(3,(status) ? 1 : 0);
        prepStmt.setDouble(4, oplata);
        prepStmt.setInt(5, id_polisy);
        prepStmt.executeUpdate();
    }

    void edytuj() throws SQLException
    {
        Scanner odczyt = new Scanner(System.in);
        System.out.println("Edycja zgloszenia\n Podaj id zgloszenia :");
        System.out.println("ID : ");
        int id_wpr = odczyt.nextInt();
        System.out.println("Opis : ");
        opis = odczyt.nextLine();
        System.out.println("Oplata : ");
        oplata = odczyt.nextDouble();
        System.out.println("ID polisy : ");
        id_polisy = odczyt.nextInt();

        System.out.println("Dzien : ");
        int d_z = odczyt.nextInt();
        System.out.println("Miesiac : ");
        int m_z = odczyt.nextInt();
        System.out.println("Rok : ");
        int r_z = odczyt.nextInt();
        data = LocalDate.of(r_z, m_z, d_z);
        java.sql.Date data_sql = java.sql.Date.valueOf( data );

        PreparedStatement prepStmt = con.prepareStatement(
                "update zgloszenie_szkody_turystycznej SET data = ?, opis = ?, status = ?, oplata_polisy = ? WHERE id = ?");
        prepStmt.setDate(1, data_sql);
        prepStmt.setString(2, opis);
        prepStmt.setInt(3,(status) ? 1 : 0);
        prepStmt.setDouble(4, oplata);
        prepStmt.setInt(5, id_wpr);
        prepStmt.executeUpdate();
    }
    
     void sprawdz_status()
    {
        if (status != false)
            System.out.println("Application.Zgloszenie istnieje");
        else
            System.out.println("Application.Zgloszenie nie istnieje");
    }
}


