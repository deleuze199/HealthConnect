package Test.Unit;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import health.NewRequests;
import health.Profile;
import java.awt.event.ActionEvent;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ProfileTest {
  Profile testProfile =new Profile("testUser");
  private ActionEvent evt = new ActionEvent(testProfile, 1, "");


  @Test
  public void makeNewRequestTest() {
    assertNotNull(testProfile.makeRequestButtonActionPerformed(evt));
  }

  @Test
  public void viewRequestTest() {
    assertNotNull(testProfile.viewRequestButtonActionPerformed(evt));
  }

  @Test
  public void yesLogoutTest() {
    Profile mockProfile = Mockito.spy(testProfile);
    Mockito.doReturn(0).when(mockProfile).askToLogout();
    assertNotNull(mockProfile.logoutActionPerformed(evt));
  }

  @Test
  public void noLogoutTest() {
    Profile mockProfile = Mockito.spy(testProfile);
    Mockito.doReturn(1).when(mockProfile).askToLogout();
    assertNull(mockProfile.logoutActionPerformed(evt));
  }

}