package Test.Unit;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.anyString;

import health.RequestConversation;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTextArea;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RequestConversationTest {


  @Test
  public void addMessageToTicketTest() throws SQLException {
    RequestConversation mockRequestConversation = spy(new RequestConversation());
    ActionEvent evt = new ActionEvent(mockRequestConversation, 1, "");
    mockRequestConversation.setAddToRequest(new JTextArea("Test"));
    Date date = new Date();
    String timestamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(date);

    Mockito.doReturn("Test").when(mockRequestConversation).addMessage("0");
    Mockito.doNothing().when(mockRequestConversation).updateMessageStatus();
    Mockito.doNothing().when(mockRequestConversation).updateGUIMessage(null);
    Mockito.doNothing().when(mockRequestConversation).updateMessageDUsername();
    Mockito.doNothing().when(mockRequestConversation).closeResultAndStatment();

    mockRequestConversation.addButtonActionPerformed(evt);

    verify(mockRequestConversation, times(1)).addMessage(anyString());
    verify(mockRequestConversation, times(1)).updateMessageStatus();
    verify(mockRequestConversation, times(1)).updateGUIMessage(anyString());
    verify(mockRequestConversation, times(1)).updateMessageDUsername();
  }
}