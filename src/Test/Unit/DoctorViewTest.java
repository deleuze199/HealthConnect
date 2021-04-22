package Test.Unit;

import static org.junit.jupiter.api.Assertions.*;

import health.DoctorView;
import org.junit.jupiter.api.Assertions;

class DoctorViewTest {
  DoctorView doctor = new DoctorView("Fauci");


  @org.junit.jupiter.api.Test
  void getUsername() {
    Assertions.assertEquals(doctor.getUsername(), "Fauci");
  }

  @org.junit.jupiter.api.Test
  void getRequestID() {
    doctor.setRequestID(100);
    Assertions.assertEquals(doctor.getRequestID(), 100);
  }

  @org.junit.jupiter.api.Test
  void getUserType() {
    doctor.setUserType("Doctor");
    Assertions.assertEquals(doctor.getUserType(), "Doctor");
  }
}