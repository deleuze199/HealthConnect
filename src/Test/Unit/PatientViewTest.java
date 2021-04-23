package Test.Unit;

import static org.junit.jupiter.api.Assertions.*;

import health.PatientView;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.swing.JButton;
import javax.swing.JList;

class PatientViewTest {

  public PatientView veiwPatient;
  public Connection conn;

  @BeforeEach
  public void setUp() {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/health", "root", "root");
    } catch (Exception e) {
      e.printStackTrace();
    }
    veiwPatient = new PatientView("patient");
    veiwPatient.setUserType("Patient");
    String sql = "INSERT into Request (PUsername, Date, Statud) VALUES ('Patient','2021-04-02','New')";

    try {
      Statement stCheck = conn.createStatement();
      stCheck.executeUpdate(sql);
    } catch (SQLException ex) {
      Logger.getLogger(PatientViewTest.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  @Test
  public void viewRequest(){
    JButton newButton = veiwPatient.getNewButton();
    JList JList1 = veiwPatient.getjList1();
    JButton openRequest = veiwPatient.getOpenRequest();

    newButton.doClick();
    JList1.setSelectedIndex(1);
    openRequest.doClick();

    Assertions.assertFalse(veiwPatient.isVisible());
  }

  @Test
  public void inProgressRequest(){
    JButton InProgressButton = veiwPatient.getInProgressButton();

    InProgressButton.doClick();

    Assertions.assertFalse(veiwPatient.isVisible());
  }
  @Test
  public void closeRequest() {
    JButton closedButton = veiwPatient.getClosedButton();

    closedButton.doClick();
  }

  @Test
   public void backButton(){
      JButton backButton = veiwPatient.getBackButton();
      backButton.doClick();
  }

    @org.junit.jupiter.api.Test
    public void getUsername () {
    }

    @org.junit.jupiter.api.Test
    void getRequestID () {
    }

    @org.junit.jupiter.api.Test
    void getUserType () {
    }
  }
