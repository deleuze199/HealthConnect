
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Matchers.anyString;

import health.RequestConversation;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RequestConversationTest {

  RequestConversation mockRequestConversation = spy(new RequestConversation());
  ActionEvent evt = new ActionEvent(mockRequestConversation, 1, "");

  @Test
  public void addMessageToTicketTest() throws SQLException {
    Mockito.doReturn("Test").when(mockRequestConversation).addMessage("0");
    Mockito.doNothing().when(mockRequestConversation).updateMessageStatus();
    Mockito.doNothing().when(mockRequestConversation).updateGUIMessage("Test");
    Mockito.doNothing().when(mockRequestConversation).updateMessageDUsername();
    Mockito.doNothing().when(mockRequestConversation).closeResultAndStatement();

    mockRequestConversation.setPane(0);
    mockRequestConversation.addButtonActionPerformed(evt);

    verify(mockRequestConversation, times(1)).addMessage(anyString());
    verify(mockRequestConversation, times(1)).updateMessageStatus();
    verify(mockRequestConversation, times(1)).updateGUIMessage(anyString());
    verify(mockRequestConversation, times(1)).updateMessageDUsername();
    verify(mockRequestConversation, times(1)).closeResultAndStatement();
  }

  @Test
  public void cancelAddMessageToTicket() throws SQLException {
    mockRequestConversation.setPane(1);
    mockRequestConversation.addButtonActionPerformed(evt);

    verify(mockRequestConversation, times(0)).addMessage(anyString());
    verify(mockRequestConversation, times(0)).updateMessageStatus();
    verify(mockRequestConversation, times(0)).updateGUIMessage(anyString());
    verify(mockRequestConversation, times(0)).updateMessageDUsername();
    verify(mockRequestConversation, times(0)).closeResultAndStatement();
  }

  @Test
  public void closeRequestTest() throws SQLException {
    Mockito.doNothing().when(mockRequestConversation).updateRequestStatus();
    Mockito.doNothing().when(mockRequestConversation).closeResultAndStatement();
    Mockito.doNothing().when(mockRequestConversation).leaveRequestPage();

    mockRequestConversation.setPane(0);
    mockRequestConversation.closeButtonActionPerformed(evt);

    verify(mockRequestConversation, times(1)).updateRequestStatus();
    verify(mockRequestConversation, times(1)).closeResultAndStatement();
    verify(mockRequestConversation, times(1)).leaveRequestPage();
  }

  @Test
  public void cancelCloseRequestTest() throws SQLException {
    mockRequestConversation.setPane(1);
    mockRequestConversation.closeButtonActionPerformed(evt);

    verify(mockRequestConversation, times(0)).updateRequestStatus();
    verify(mockRequestConversation, times(0)).closeResultAndStatement();
    verify(mockRequestConversation, times(0)).leaveRequestPage();
  }

  @Test
  public void backButtonTest() {
    Mockito.doNothing().when(mockRequestConversation).closeResultAndStatement();
    Mockito.doNothing().when(mockRequestConversation).leaveRequestPage();

    mockRequestConversation.backButtonActionPerformed(evt);

    verify(mockRequestConversation, times(1)).closeResultAndStatement();
    verify(mockRequestConversation, times(1)).leaveRequestPage();
  }
}