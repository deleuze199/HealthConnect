package health;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Health {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) { // TODO code application logic here
    @SuppressWarnings("UnusedAssignment") //test connection
        Connection conn = null;
    //Statement statement = null;

    try {
      // Creates a connection to the database
      Class.forName("com.mysql.cj.jdbc.Driver");
      conn = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/health", "root", "root");

//open login page
      NewJFrame s = new NewJFrame();
      s.setVisible(true);
    } catch (ClassNotFoundException | SQLException e) {
      JOptionPane.showMessageDialog(null, e);
      System.out.println(e);
    }
  }
}
